var status = false;
var highestctr= "";
var highestcpc= "";
var highestcpm= "";

var sortedCtrHighArray = new Array();
var sortedCtrLowArray = new Array();
var sortedCtrMediumArray = new Array();
var sortedCtrHighNameArray = new Array();
var sortedCtrLowNameArray = new Array();
var sortedCtrMediumNameArray = new Array();


var sortedCpcHighArray = new Array();
var sortedCpcLowArray = new Array();
var sortedCpcMediumArray = new Array();
var sortedCpcHighNameArray = new Array();
var sortedCpcLowNameArray = new Array();
var sortedCpcMediumNameArray = new Array();

var sortedCpmHighArray = new Array();
var sortedCpmLowArray = new Array();
var sortedCpmMediumArray = new Array();
var sortedCpmHighNameArray = new Array();
var sortedCpmLowNameArray = new Array();
var sortedCpmMediumNameArray = new Array();

var testCtrArray = new Array();
var testCpcArray = new Array();
var testCpmArray = new Array();
$(document).ready(function()
{
	
	$('#uploadcsv').click(function()
	{
				$('#inputfile').trigger('click');
				$('#hideandshow').show();
	});
	$('#uploadneuroph').click(function()
			{
					$('#inputneuroph').trigger('click');
						$('#hideandshow').show();
			});
	$('#uploadimage').click(function()
	{
						$('#inputimage').trigger('click');
						$('#hideandshow').show();
	});
	$('#hmm').click(function()
	{
		window.location.href="/hmm.jsp";
	});
	$('#search').keypress(function(e)
	{
		
		if(e.which == 13)
		{
			var searchterm = $('#search').val();
			$('#outputEmissionProb_filter').css('font-size','12px !important');
			$('#outputEmissionProb_info').css('font-size','12px !important');
			$('#outputEmissionProb_length').css('font-size','12px !important');
			saveemission();
			$('#loadings').show();
			$('#statusmsgs').show();
			$('#statusmsgs').html('Job sucessfully created. Approx wait time '+getWaitTimeArbitrary(30,40)+'');
			$('#statusmsgs').show();
			$('#output1').show();
			$.ajax({
				type	: 'GET', 
				url		: '/search' ,
				data 	: {searchterm : searchterm},
				async	: false,
				success	: function(data)
			    {
					var response = JSON.parse(data);
					console.log(response);
					 highestctr= cookies.gethighestctr();
					 highestcpc= cookies.gethighestcpc();
					 highestcpm= cookies.gethighestcpm();
					 
					 for(index in response)
					 {
						 testCtrArray.push(response[index].ctr);
						 testCpcArray.push(response[index].cpc);
						 testCpmArray.push(response[index].cpm);
					 }
					 testCtrArray = testCtrArray.sort(function(a,b){return b-a});
					 testCpcArray = testCpcArray.sort(function(a,b){return b-a});
					 testCpmArray = testCpmArray.sort(function(a,b){return b-a});
					 console.log(testCtrArray);
					 console.log(testCpcArray);
					 console.log(testCpmArray);
					 var mediumCtr = (testCtrArray[0]+testCtrArray[testCtrArray.length-1])/2;
					 var mediumCpc = (testCpcArray[0]+testCpcArray[testCpcArray.length-1])/2;
					 var mediumCpm = (testCpmArray[0]+testCpmArray[testCtrArray.length-1])/2;
					 console.log("mediumCtr :: "+mediumCtr);
					 console.log("mediumCpc :: "+mediumCpc);
					 console.log("mediumCpm :: "+mediumCpm);
					for(index in response)
					{
						if(response[index].ctr > highestctr )
						{
							 sortedCtrHighArray.push(response[index].images);
							 sortedCtrHighNameArray.push(response[index].ctr);
						}
						if( response[index].ctr < highestctr )
						{
							 sortedCtrLowArray.push(response[index].images);
							 sortedCtrLowNameArray.push(response[index].ctr);
						}
						if(mediumCtr+50 > highestctr  || mediumCtr-50 < highestctr)
						{
							sortedCtrMediumArray.push(response[index].images);
							sortedCtrMediumNameArray.push(response[index].ctr);
						}
						
						if( response[index].cpc > highestcpc )
						{
							 sortedCpcHighArray.push(response[index].images);
							 sortedCpcHighNameArray.push(response[index].cpc);
						}
						if(response[index].cpc < highestcpc )
						{
							 sortedCpcLowArray.push(response[index].images);
							 sortedCpcLowNameArray.push(response[index].cpc);
						}
						if( mediumCpc+50 > highestcpc  || mediumCpc-50 < highestcpc)
						{
							sortedCpcMediumArray.push(response[index].images);
							sortedCpcMediumNameArray.push(response[index].cpc);
						}
						

						if( response[index].cpm > highestcpm)
						{
							 sortedCpmHighArray.push(response[index].images);
							 sortedCpmHighNameArray.push(response[index].cpm);
						}
						if( response[index].cpm < highestcpm)
						{
							 sortedCpmLowArray.push(response[index].images);
							 sortedCpmLowNameArray.push(response[index].cpm);
						}
						if( mediumCpm+50 > highestcpm || mediumCpm-50 < highestcpm)
						{
							sortedCpmMediumArray.push(response[index].images);
							sortedCpmMediumNameArray.push(response[index].cpm);
						}
//						
					}
					for(var highctr=0; highctr<sortedCtrHighArray.length; highctr++)
					{
						console.log("inside 1 loop");
						var htmltoBuild = '<div class="4u">'+
						'<article class="item">'+
						'<a href="#" class="image fit"><img src="'+sortedCtrHighArray[highctr]+'" alt="" /></a>'+
						'<header>'+
						'<h3>'+sortedCtrHighNameArray[highctr]+'</h3>'+
						'</header>'+
						'</article>'+
						'</div>';
						$('#highctrcategory').append(htmltoBuild);
					}
					for(var lowctr=0; lowctr<sortedCtrLowArray.length; lowctr++)
					{
						console.log("inside 2 loop");
						var htmltoBuild = '<div class="4u">'+
						'<article class="item">'+
						'<a href="#" class="image fit"><img src="'+sortedCtrLowArray[lowctr]+'" alt="" /></a>'+
						'<header>'+
						'<h3>'+sortedCtrLowNameArray[lowctr]+'</h3>'+
						'</header>'+
						'</article>'+
						'</div>';
						$('#lowctrcategory').append(htmltoBuild);
					}
					for(var mediumctr=0; mediumctr<sortedCtrMediumArray.length; mediumctr++)
					{
						console.log("inside 3 loop");
						var htmltoBuild = '<div class="4u">'+
						'<article class="item">'+
						'<a href="#" class="image fit"><img src="'+sortedCtrMediumArray[mediumctr]+'" alt="" /></a>'+
						'<header>'+
						'<h3>'+sortedCtrMediumNameArray[mediumctr]+'</h3>'+
						'</header>'+
						'</article>'+
						'</div>';
						$('#mediumctrcategory').append(htmltoBuild);
					}
					
					
					
					for(var highcpc=0; highcpc<sortedCpcHighArray.length; highcpc++)
					{
						console.log("inside 4 loop");
						var htmltoBuild = '<div class="4u">'+
						'<article class="item">'+
						'<a href="#" class="image fit"><img src="'+sortedCpcHighArray[highcpc]+'" alt="" /></a>'+
						'<header>'+
						'<h3>'+sortedCpcHighNameArray[highcpc]+'</h3>'+
						'</header>'+
						'</article>'+
						'</div>';
						$('#highcpccategory').append(htmltoBuild);
					}
					for(var lowcpc=0; lowcpc<sortedCpcLowArray.length; lowcpc++)
					{
						console.log("inside 5 loop");
						var htmltoBuild = '<div class="4u">'+
						'<article class="item">'+
						'<a href="#" class="image fit"><img src="'+sortedCpcLowArray[lowcpc]+'" alt="" /></a>'+
						'<header>'+
						'<h3>'+sortedCpcLowNameArray[lowcpc]+'</h3>'+
						'</header>'+
						'</article>'+
						'</div>';
						$('#lowcpccategory').append(htmltoBuild);
					}
					for(var mediumcpc=0; mediumcpc<sortedCpcMediumArray.length; mediumcpc++)
					{
						console.log("inside 6 loop");
						var htmltoBuild = '<div class="4u">'+
						'<article class="item">'+
						'<a href="#" class="image fit"><img src="'+sortedCpcMediumArray[mediumcpc]+'" alt="" /></a>'+
						'<header>'+
						'<h3>'+sortedCpcMediumNameArray[mediumcpc]+'</h3>'+
						'</header>'+
						'</article>'+
						'</div>';
						$('#mediumcpccategory').append(htmltoBuild);
					}
					
					
					
					for(var highcpm=0; highcpm<sortedCtrHighArray.length; highcpm++)
					{
						console.log("inside 7 loop");
						var htmltoBuild = '<div class="4u">'+
						'<article class="item">'+
						'<a href="#" class="image fit"><img src="'+sortedCpmHighArray[highcpm]+'" alt="" /></a>'+
						'<header>'+
						'<h3>'+sortedCpmHighNameArray[highcpm]+'</h3>'+
						'</header>'+
						'</article>'+
						'</div>';
						$('#highcpmcategory').append(htmltoBuild);
					}
					for(var lowcpm=0; lowcpm<sortedCpmLowArray.length; lowcpm++)
					{
						console.log("inside 8 loop");
						var htmltoBuild = '<div class="4u">'+
						'<article class="item">'+
						'<a href="#" class="image fit"><img src="'+sortedCpmLowArray[lowcpm]+'" alt="" /></a>'+
						'<header>'+
						'<h3>'+sortedCpmLowNameArray[lowcpm]+'</h3>'+
						'</header>'+
						'</article>'+
						'</div>';
						$('#lowcpmcategory').append(htmltoBuild);
					}
					for(var mediumcpm=0; mediumcpm<sortedCpmMediumArray.length; mediumcpm++)
					{
						console.log("inside 9 loop");
						var htmltoBuild = '<div class="4u">'+
						'<article class="item">'+
						'<a href="#" class="image fit"><img src="'+sortedCpmMediumArray[mediumcpm]+'" alt="" /></a>'+
						'<header>'+
						'<h3>'+sortedCpmMediumNameArray[mediumcpm]+'</h3>'+
						'</header>'+
						'</article>'+
						'</div>';
						$('#mediumcpmcategory').append(htmltoBuild);
					}
					$('#loadings').show();
					$('#statusmsgs').html('Query Processed Successfully...Fetching Images from Blobstore..Approx wait time '+getWaitTimeArbitrary(30,40)+' Seconds');
					setTimeout(function() { fetchimages(); }, 25000);
//					fetchimages();
			    }
			});
		}
	});
});

function fetchimages()
{
	$('#statusmsgs').html("Sorted Out..");
	$('#loadings').hide();
	$('#ctrsection').show();
	$('#cpcsection').show();
	$('#cpmsection').show();
}
function deleteExisting()
{
	$.ajax({
			type	: 'GET', 
			url		: '/deleteExisting' ,
			async	: false,
			success	: function(data)
		    {
					$('#loading').show();
					$('#statusmsg').show();
					setTimeout(function() { saveprocess(); }, 15000);
					status = true;
		    }
		});
}
function saveprocess()
{
	alert("Data Deleted");
	$('#processhmm').show();
	$('#statusmsg').hide();
	$('#loading').hide();
}
function saveContactdetails()
{
	$('#statusmsg').html("Generating Transition Probablity Report ! Please Wait..");
	$.get('hmmreport',function(data)
			{
		       	 var jsonvars				=	JSON.parse(data);
		       	 console.log("ui");
		       	 console.log(jsonvars);
		      	  	dtable = $('#outputActualProb').dataTable({
						"bDestroy" : true,
						"aoColumns" : [{
							"sTitle" : "Item",
							"sWidth" : "10%",
							"sClass" : "center"
						},{
							"sTitle" : "Location",
							"sWidth" : "10%",
							"sClass" : "center"
						},{
							"sTitle" : "Session",
							"sWidth" : "5%",
							"sClass" : "center"
						},{
							"sTitle" : "CTR",   // needed 1
							"sWidth" : "20%",
							"sClass" : "center"
						},{
							"sTitle" : "CPC",   // needed 3
							"sWidth" : "10%",
							"sClass" : "center"
						},{
							"sTitle" : "CPM",
							"sWidth" : "10%",
							"sClass" : "center"
						},{ 
							"sTitle" : "CR",   // needed 2
							"sWidth" : "10%",
							"sClass" : "center"
						},{
							"sTitle" : "CPA",
							"sWidth" : "25%",
							"sClass" : "center"
						}]
					});
					dtable.fnClearTable();
					var newRow = [];
					for(index in jsonvars)
					{
						newRow[0] = "0.0";
						newRow[1] = "0.0";
						newRow[2] = "0.0";
						newRow[3] = jsonvars[index].ctr;
						newRow[4] = jsonvars[index].cpm;
						newRow[5] = "0.0";
						newRow[6] = jsonvars[index].cpa;
						newRow[7] = "0.0";
						dtable.fnAddData(newRow);
					}
						dtable.fnDraw();
						$('#main').show();
						$('#output1').show();
						setTimeout(function() { saveemission(); }, 15000);
			});	
}
function getWaitTimeArbitrary(min, max) {
    return Math.random() * (max - min) + min;
}
function saveemission()
{
	$('#statusmsg').html("Generating Emission Probablity Report ! Please Wait..");
	var ctrArray = new Array();
	var cpcArray = new Array();
	var cpmArray = new Array();
	$.get('emissionreport',function(data)
			{
				       	 var jsonvars				=	JSON.parse(data);
				       	 console.log("ui");
				       	 console.log(jsonvars);
				      	  	dtabless = $('#outputEmissionProb').dataTable({
								"bDestroy" : true,
								"aoColumns" : [{
									"sTitle" : "Item",
									"sWidth" : "10%",
									"sClass" : "center"
								},{
									"sTitle" : "Location",
									"sWidth" : "10%",
									"sClass" : "center"
								},{
									"sTitle" : "Session",
									"sWidth" : "5%",
									"sClass" : "center"
								},{
									"sTitle" : "CTR",
									"sWidth" : "20%",
									"sClass" : "center"
								},{
									"sTitle" : "CPC",
									"sWidth" : "10%",
									"sClass" : "center"
								},{
									"sTitle" : "CPM",
									"sWidth" : "10%",
									"sClass" : "center"
								},{
									"sTitle" : "CR",
									"sWidth" : "10%",
									"sClass" : "center"
								},{
									"sTitle" : "CPA",
									"sWidth" : "25%",
									"sClass" : "center"
								}]
							});
				      	  	dtabless.fnClearTable();
							var newRow = [];
							for(index in jsonvars)
							{
								newRow[0] = jsonvars[index].items;
								newRow[1] = jsonvars[index].location;
								newRow[2] = jsonvars[index].session;
								newRow[3] = jsonvars[index].ctr;
								newRow[4] = jsonvars[index].cpc;
								newRow[5] = jsonvars[index].cpm;
								newRow[6] = jsonvars[index].cr;
								newRow[7] = jsonvars[index].cpa;
								ctrArray.push(jsonvars[index].ctr);
								cpcArray.push(jsonvars[index].cpc);
								cpmArray.push(jsonvars[index].cpm);
								dtabless.fnAddData(newRow);
							}
							dtabless.fnDraw();
								$('#main').show();
								$('#loading').hide();
								$('#output2').show();
								$('#statusmsg').html("All Reports Generated Successfully !");
							var highestCTR = ctrArray.sort(function(a,b){return b-a});
							var highestCPC = cpcArray.sort(function(a,b){return b-a});
							var highestCPM = cpmArray.sort(function(a,b){return b-a});
							$('#toshow').show();
							$('#highestctr').html(highestCTR[0]);
							$('#highestcpc').html(highestCPC[0]);
							$('#highestcpm').html(highestCPM[0]);
							cookies.sethighestctr(highestCTR[0]);
							cookies.sethighestcpc(highestCPC[0]);
							cookies.sethighestcpm(highestCPM[0]);
					});
}
function processhm()
{
	$('#statusmsg').html("Processing ! Please Wait..");
	if(status)
	{
			$('#loading').show();
			$('#statusmsg').html("Processing ! Please Wait..");
			$('#statusmsg').show();
			$.ajax({
				type	: 'GET', 
				url	    : '/processhmmmodel' ,
				async	: false,
				success	: function(data)
	 	    	{
					$('#statusmsg').html("HMM Processed Successfully ! Please Wait..");
					setTimeout(function() { saveContactdetails(); }, 15000);
	 	    	}
			});
	}
	else
	{
		alert("Please delete the existing data to continue");
	}
}
		