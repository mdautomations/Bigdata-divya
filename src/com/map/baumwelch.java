package com.map;

import java.lang.reflect.Array;
import java.text.*;
import java.util.*;

import javax.jdo.PersistenceManager;

import com.map.*;


class HMM {
  int nstate;           // number of states (incl initial state)
  String[] state;       // names of the states
  double[][] loga;      // loga[k][ell] = log(P(k -> ell))

  int nesym;            // number of emission symbols
  String esym;          // the emission symbols e1,...,eL (characters)
  double[][] loge;      // loge[k][ei] = log(P(emit ei in state k))


  public HMM(String[] state, double[][] amat,String esym, double[][] emat) {
    if (state.length != amat.length)
      throw new IllegalArgumentException("HMM: state and amat disagree");
    if (amat.length != emat.length)
      throw new IllegalArgumentException("HMM: amat and emat disagree");
    for (int i=0; i<amat.length; i++) {
      if (state.length != amat[i].length)
        throw new IllegalArgumentException("HMM: amat non-square");
      if (esym.length() != emat[i].length)
        throw new IllegalArgumentException("HMM: esym and emat disagree");
    }      

    nstate = state.length + 1;
    this.state = new String[nstate];
    loga = new double[nstate][nstate];
    this.state[0] = "B";        // initial state
    loga[0][0] = Double.NEGATIVE_INFINITY; // = log(0)
    double fromstart = Math.log(1.0/state.length);
    for (int j=1; j<nstate; j++)
      loga[0][j] = fromstart;
    for (int i=1; i<nstate; i++) {
      this.state[i] = new StringBuffer(state[i-1]).reverse().toString();
      loga[i][0] = Double.NEGATIVE_INFINITY; // = log(0)
      for (int j=1; j<nstate; j++)
        loga[i][j] = Math.log(amat[i-1][j-1]);
    }
    
    this.esym = esym;
    nesym = esym.length();
    loge = new double[emat.length+1][91];
    for (int b=0; b<nesym; b++) {
      char eb = esym.charAt(b);
      loge[0][eb] = Double.NEGATIVE_INFINITY; // = log(0)
      for (int k=0; k<emat.length; k++) 
        loge[k+1][eb] = Math.log(emat[k][b]);
    }
  }

  public void print(Output out) 
  { printa(out); printe(out); }

  public void printa(Output out) 
  {
    out.println("Transition probabilities:");
    new deleteExisting().mini();
    new deleteExisting().mini2();
    for (int i=1; i<nstate; i++) 
    {
    	actualprob entry						=				new actualprob();
      List<String> 			entrylist					=				new ArrayList<String>();
      for (int j=1; j<nstate; j++) 
      {
    	  out.print(fmtlog(loga[i][j]));  
    	  entrylist.add(fmtlog(loga[i][j]));
      }
      if(entrylist!=null && entrylist.size()>0)
      {
    	  UUID 		uniqueKey		= 				UUID.randomUUID();
    	  PersistenceManager  pm         = 		PMF.get().getPersistenceManager();
          entry.setKey(uniqueKey.toString());
          entry.setCTR(entrylist.get(0));
          entry.setCPM(entrylist.get(1));
          entry.setCPA(entrylist.get(2));
          pm.currentTransaction().begin();
    		pm.makePersistent(entry);
    		pm.currentTransaction().commit();
    		 pm.close();
      }
      out.println();
     
    }
 
    
  }

  public void printe(Output out) 
  {
	  new deleteExisting().mini2();
    out.println("Emission probabilities:");
    for (int b=0; b<nesym; b++)
    {
    	 out.print(esym.charAt(b) + hdrpad);	
    }
    out.println();
    for (int i=1; i<loge.length; i++) 
    {
    	emissionprob entry						=				new emissionprob();
    	List<String> 			entrylist					=				new ArrayList<String>();
    	
      for (int b=0; b<nesym; b++)
      {
    	  out.print(fmtlog(loge[i][esym.charAt(b)])); 
    	  entrylist.add(fmtlog(loge[i][esym.charAt(b)]));
      }
      if(entrylist!=null && entrylist.size()>0)
      {
    	  UUID 		uniqueKey		= 				UUID.randomUUID();
    	  PersistenceManager  pm         = 		PMF.get().getPersistenceManager();
          entry.setKey(uniqueKey.toString());
          entry.setItems(entrylist.get(0));
          entry.setLocation(entrylist.get(1));
          entry.setSession(entrylist.get(2));
          entry.setCTR(entrylist.get(3));
          entry.setCPC(entrylist.get(4));
          entry.setCPM(entrylist.get(5));
          entry.setCR(entrylist.get(6));
          entry.setCPA(entrylist.get(7));
          pm.currentTransaction().begin();
    	  pm.makePersistent(entry);
    	  pm.currentTransaction().commit();
    	  pm.close();
      }
      out.println();
     
    }
  }

  private static DecimalFormat fmt = new DecimalFormat("0.000000 ");
  private static String hdrpad     =                    "        ";

  public static String fmtlog(double x) {
    if (x == Double.NEGATIVE_INFINITY)
      return fmt.format(0);
    else
      return fmt.format(Math.exp(x));
  }


  public static HMM baumwelch(String[] xs, String[] state, 
                              String esym, final double threshold) {
    int nstate = state.length;
    int nseqs  = xs.length;
    int nesym  = esym.length();

    Forward[] fwds = new Forward[nseqs];
    Backward[] bwds = new Backward[nseqs];
    double[] logP = new double[nseqs];
    
    double[][] amat = new double[nstate][];
    double[][] emat = new double[nstate][];

    int[] esyminv = new int[91];
    for (int i=0; i<esyminv.length; i++)
      esyminv[i] = -1;
    for (int b=0; b<nesym; b++)
      esyminv[esym.charAt(b)] = b;

    for (int k=0; k<nstate; k++) {
      amat[k] = randomdiscrete(nstate);
      emat[k] = randomdiscrete(nesym);
    }

    HMM hmm = new HMM(state, amat, esym, emat);
    
    double oldloglikelihood;

    double loglikelihood = fwdbwd(hmm, xs, fwds, bwds, logP);
    System.out.println("log likelihood = " + loglikelihood);
    do {
      oldloglikelihood = loglikelihood;
      double[][] A = new double[nstate][nstate];
      double[][] E = new double[nstate][nesym];
      for (int s=0; s<nseqs; s++) {
        String x = xs[s];
        Forward fwd  = fwds[s];
        Backward bwd = bwds[s];
        int L = x.length();
        double P = logP[s];	
        for (int i=0; i<L; i++) {
          for (int k=0; k<nstate; k++) 
            E[k][esyminv[x.charAt(i)]] += exp(fwd.f[i+1][k+1] 
                                              + bwd.b[i+1][k+1] 
                                              - P);
        }
        for (int i=0; i<L-1; i++) 
          for (int k=0; k<nstate; k++) 
            for (int ell=0; ell<nstate; ell++) 
              A[k][ell] += exp(fwd.f[i+1][k+1] 
                               + hmm.loga[k+1][ell+1] 
                               + hmm.loge[ell+1][x.charAt(i+1)] 
                               + bwd.b[i+2][ell+1] 
                               - P);
      }
      // Estimate new model parameters
      for (int k=0; k<nstate; k++) {
        double Aksum = 0;
        for (int ell=0; ell<nstate; ell++) 
          Aksum += A[k][ell];
        for (int ell=0; ell<nstate; ell++) 
          amat[k][ell] = A[k][ell] / Aksum;
        double Eksum = 0;
        for (int b=0; b<nesym; b++) 
          Eksum += E[k][b];
        for (int b=0; b<nesym; b++) 
          emat[k][b] = E[k][b] / Eksum;
      }
      hmm = new HMM(state, amat, esym, emat);
      loglikelihood = fwdbwd(hmm, xs, fwds, bwds, logP);
      System.out.println("log likelihood = " + loglikelihood);
    } while (Math.abs(oldloglikelihood - loglikelihood) > threshold);
    return hmm;
  }

  private static double fwdbwd(HMM hmm, String[] xs, Forward[] fwds, 
                               Backward[] bwds, double[] logP) {
    double loglikelihood = 0;
    for (int s=0; s<xs.length; s++) {
      fwds[s] = new Forward(hmm, xs[s]);
      bwds[s] = new Backward(hmm, xs[s]);
      logP[s] = fwds[s].logprob();
      loglikelihood += logP[s];
    }
    return loglikelihood;
  }

  public static double exp(double x) {
    if (x == Double.NEGATIVE_INFINITY)
      return 0;
    else
      return Math.exp(x);
  }

  private static double[] uniformdiscrete(int n) {
    double[] ps = new double[n];
    for (int i=0; i<n; i++) 
      ps[i] = 1.0/n;
    return ps;
  }    

  private static double[] randomdiscrete(int n) {
    double[] ps = new double[n];
    double sum = 0;
    // Generate random numbers
    for (int i=0; i<n; i++) {
      ps[i] = Math.random();
      sum += ps[i];
    }
    // Scale to obtain a discrete probability distribution
    for (int i=0; i<n; i++) 
      ps[i] /= sum;
    return ps;
  }
}


abstract class HMMAlgo {
  HMM hmm;                      // the hidden Markov model
  String x;                     // the observed string of emissions

  public HMMAlgo(HMM hmm, String x) 
  { this.hmm = hmm; this.x = x; }

  static double logplus(double plog, double qlog) {
    double max, diff;
    if (plog > qlog) {
      if (qlog == Double.NEGATIVE_INFINITY)
        return plog;
      else {
        max = plog; diff = qlog - plog;
      } 
    } else {
      if (plog == Double.NEGATIVE_INFINITY)
        return qlog;
      else {
        max = qlog; diff = plog - qlog;
      }
    }
    return max + (diff < -37 ? 0 : Math.log(1 + Math.exp(diff)));
  }
}

class TestLogPlus {
  public static void main(String[] args) {
    final double EPS = 1E-14;
    Random rnd = new Random();
    int count = Integer.parseInt(args[0]);
    for (int k=200; k>=-200; k--) 
      for (int i=0; i<count; i++) {
	double logp = Math.abs(rnd.nextDouble()) * Math.pow(10, k);
	double logq = Math.abs(rnd.nextDouble());
	double logpplusq = HMMAlgo.logplus(logp, logq);
	double p = Math.exp(logp), 
	  q = Math.exp(logq), 
	  pplusq = Math.exp(logpplusq);
	if (Math.abs(p+q-pplusq) > EPS * pplusq) 
	  System.out.println(p + "+" + q + "-" + pplusq);
      }
  }
}

class Viterbi extends HMMAlgo {
  double[][] v;         // the matrix used to find the decoding
                        // v[i][k] = v_k(i) = 
                        // log(max(P(pi in state k has sym i | path pi)))
  Traceback2[][] B;     // the traceback matrix
  Traceback2 B0;        // the start of the traceback 

  public Viterbi(HMM hmm, String x) {
    super(hmm, x);
    final int L = x.length();
    v = new double[L+1][hmm.nstate];
    B = new Traceback2[L+1][hmm.nstate];
    v[0][0] = 0;                // = log(1)
    for (int k=1; k<hmm.nstate; k++)
      v[0][k] = Double.NEGATIVE_INFINITY; // = log(0)
    for (int i=1; i<=L; i++)
      v[i][0] = Double.NEGATIVE_INFINITY; // = log(0)
    for (int i=1; i<=L; i++)
      for (int ell=0; ell<hmm.nstate; ell++) {
        int kmax = 0;
        double maxprod = v[i-1][kmax] + hmm.loga[kmax][ell];
        for (int k=1; k<hmm.nstate; k++) {
          double prod = v[i-1][k] + hmm.loga[k][ell];
          if (prod > maxprod) {
            kmax = k;
            maxprod = prod;
          }
        }
        v[i][ell] = hmm.loge[ell][x.charAt(i-1)] + maxprod;
        B[i][ell] = new Traceback2(i-1, kmax);
      }
    int kmax = 0;
    double max = v[L][kmax];
    for (int k=1; k<hmm.nstate; k++) {
      if (v[L][k] > max) {
        kmax = k;
        max = v[L][k];
      }
    }
    B0 = new Traceback2(L, kmax);
  }

  public String getPath() {
    StringBuffer res = new StringBuffer();
    Traceback2 tb = B0;
    int i = tb.i, j = tb.j;
    while ((tb = B[tb.i][tb.j]) != null) {
      res.append(hmm.state[j]);
      i = tb.i; j = tb.j;
    }        
    return res.reverse().toString();
  }

  public void print(Output out) {
    for (int j=0; j<hmm.nstate; j++) {
      for (int i=0; i<v.length; i++)
        out.print(HMM.fmtlog(v[i][j]));
      out.println();
    }
  }
}

class Forward extends HMMAlgo {
  double[][] f;                 // the matrix used to find the decoding
                                // f[i][k] = f_k(i) = log(P(x1..xi, pi_i=k))
  private int L; 

  public Forward(HMM hmm, String x) {
    super(hmm, x);
    L = x.length();
    f = new double[L+1][hmm.nstate];
    f[0][0] = 0;                // = log(1)
    for (int k=1; k<hmm.nstate; k++)
      f[0][k] = Double.NEGATIVE_INFINITY; // = log(0)
    for (int i=1; i<=L; i++)
      f[i][0] = Double.NEGATIVE_INFINITY; // = log(0)
    for (int i=1; i<=L; i++)
      for (int ell=1; ell<hmm.nstate; ell++) {
        double sum = Double.NEGATIVE_INFINITY; // = log(0)
        for (int k=0; k<hmm.nstate; k++) 
          sum = logplus(sum, f[i-1][k] + hmm.loga[k][ell]);
        f[i][ell] = hmm.loge[ell][x.charAt(i-1)] + sum;
      }
  }

  double logprob() {
    double sum = Double.NEGATIVE_INFINITY; // = log(0)
    for (int k=0; k<hmm.nstate; k++) 
      sum = logplus(sum, f[L][k]);
    return sum;
  }

  public void print(Output out) {
    for (int j=0; j<hmm.nstate; j++) {
      for (int i=0; i<f.length; i++)
        out.print(HMM.fmtlog(f[i][j]));
      out.println();
    }
  }
}

class Backward extends HMMAlgo {
  double[][] b;               // the matrix used to find the decoding
                              // b[i][k] = b_k(i) = log(P(x(i+1)..xL, pi_i=k))

  public Backward(HMM hmm, String x) {
    super(hmm, x);
    int L = x.length();
    b = new double[L+1][hmm.nstate];
    for (int k=1; k<hmm.nstate; k++)
      b[L][k] = 0;              // = log(1)  // should be hmm.loga[k][0]
    for (int i=L-1; i>=1; i--)
      for (int k=0; k<hmm.nstate; k++) {
        double sum = Double.NEGATIVE_INFINITY; // = log(0)
        for (int ell=1; ell<hmm.nstate; ell++) 
          sum = logplus(sum, hmm.loga[k][ell] 
                             + hmm.loge[ell][x.charAt(i)] 
                             + b[i+1][ell]);
        b[i][k] = sum;
      }
  }

  double logprob() {
    double sum = Double.NEGATIVE_INFINITY; // = log(0)
    for (int ell=0; ell<hmm.nstate; ell++) 
      sum = logplus(sum, hmm.loga[0][ell] 
                         + hmm.loge[ell][x.charAt(0)] 
                         + b[1][ell]);
    return sum;
  }

  public void print(Output out) {
    for (int j=0; j<hmm.nstate; j++) {
      for (int i=0; i<b.length; i++)
        out.print(HMM.fmtlog(b[i][j]));
      out.println();
    }
  }
}



class PosteriorProb {
  Forward fwd;                  // result of the forward algorithm 
  Backward bwd;                 // result of the backward algorithm 
  private double logprob;

  PosteriorProb(Forward fwd, Backward bwd) {
    this.fwd = fwd; this.bwd = bwd;
    logprob = fwd.logprob();    // should equal bwd.logprob()
  }

  double posterior(int i, int k) // i=index into the seq; k=the HMM state
  { return Math.exp(fwd.f[i][k] + bwd.b[i][k] - logprob); }
}


// Traceback objects

abstract class Traceback {
  int i, j;                     // absolute coordinates
}


// Traceback2 objects

class Traceback2 extends Traceback {
  public Traceback2(int i, int j)
  { this.i = i; this.j = j; }
}


// Auxiliary classes for output

abstract class Output {
  public abstract void print(String s);
  public abstract void println(String s);
  public abstract void println();
}

class SystemOut extends Output {
  public void print(String s)
  { System.out.print(s); }

  public void println(String s)
  { System.out.println(s); }

  public void println()
  { System.out.println(); }
}


public class baumwelch {
  public static void main(String[] args) {
	  
	  for(int i=0; i<=1000; i++)
	  {
		  Random rn = new Random();
		  int answer = rn.nextInt(20) + 1;
		  System.out.println(answer);
	  }
    dice();
    // CpG();
  }

  static void dice() {
    String[] state = { "H", "L" ,"M"};
    double[][] aprob = { { 0.90, 0.05, 0.05  },
                         { 0.05, 0.90, 0.05  } ,
                         { 0.05, 0.05, 0.90 } };
    String esym = "12345678";
    double[][] eprob = { { 0.10,  0.10,  0.10,  0.10,  0.10,  0.20, 0.20, 0.10 },
                         { 0.10,  0.10,  0.10,  0.10,  0.10,  0.10, 0.35, 0.05 }, 
                         { 0.10,  0.10,  0.10,  0.10,  0.40,  0.10, 0.05, 0.05 }   };
    
    HMM hmm = new HMM(state, aprob, esym, eprob);
   
    String x = 
      "315116246446644245311321631164152133625144543631656626566666"
    + "651166453132651245636664631636663162326455236266666625151631"
    + "222555441666566563564324364131513465146353411126414626253356"
    + "366163666466232534413661661163252562462255265252266435353336"
    + "233121625364414432335163243633665562466662632666612355245242";

    String[] xs = { x };
    HMM estimate = HMM.baumwelch(xs, state, esym, 0.00001);
    estimate.print(new SystemOut());
  }

  static void CpG() {
    String[] state = { "A+", "C+", "G+", "T+", "A-", "C-", "G-", "T-" };
    double p2m = 0.05;          // P(switch from plus to minus)
    double m2p = 0.01;          // P(switch from minus to plus)
    double[][] aprob = { 
      { 0.180-p2m, 0.274-p2m, 0.426-p2m, 0.120-p2m, p2m, p2m, p2m, p2m },
      { 0.171-p2m, 0.368-p2m, 0.274-p2m, 0.188-p2m, p2m, p2m, p2m, p2m },
      { 0.161-p2m, 0.339-p2m, 0.375-p2m, 0.125-p2m, p2m, p2m, p2m, p2m }, 
      { 0.079-p2m, 0.335-p2m, 0.384-p2m, 0.182-p2m, p2m, p2m, p2m, p2m },
      { m2p, m2p, m2p, m2p,  0.300-m2p, 0.205-m2p, 0.285-m2p, 0.210-m2p },
      { m2p, m2p, m2p, m2p,  0.322-m2p, 0.298-m2p, 0.078-m2p, 0.302-m2p },
      { m2p, m2p, m2p, m2p,  0.248-m2p, 0.246-m2p, 0.298-m2p, 0.208-m2p },
      { m2p, m2p, m2p, m2p,  0.177-m2p, 0.239-m2p, 0.292-m2p, 0.292-m2p } };

    String esym = "ACGT";
    double[][] eprob = { { 1, 0, 0, 0 },
                         { 0, 1, 0, 0 },
                         { 0, 0, 1, 0 },
                         { 0, 0, 0, 1 },
                         { 1, 0, 0, 0 },
                         { 0, 1, 0, 0 },
                         { 0, 0, 1, 0 },
                         { 0, 0, 0, 1 } };

    HMM hmm = new HMM(state, aprob, esym, eprob);

    String x = "CGCG";
    Viterbi vit = new Viterbi(hmm, x);
    vit.print(new SystemOut());
    System.out.println(vit.getPath());
  }
}

