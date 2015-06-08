var cookies = 
{
	getRegistrationUrlCookie	:	function()
	{
		var i,x,y,ARRcookies	=		document.cookie.split(";");
		content						= 		"cookie";
		for (i=0;i<ARRcookies.length;i++)
		{
		  x			=		ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
		  y		=		ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
		  x			=		x.replace(/^\s+|\s+$/g,"");
		  if (x==content)
		  {
			  return unescape(y);
		  }
		}
	},
	gethighestctr	:	function()
	{
		var i,x,y,ARRcookies	=		document.cookie.split(";");
		content						= 		"highestctr";
		for (i=0;i<ARRcookies.length;i++)
		{
		  x			=		ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
		  y		=		ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
		  x			=		x.replace(/^\s+|\s+$/g,"");
		  if (x==content)
		  {
			  return unescape(y);
		  }
		}
	},
	gethighestcpc	:	function()
	{
		var i,x,y,ARRcookies	=		document.cookie.split(";");
		content						= 		"highestcpc";
		for (i=0;i<ARRcookies.length;i++)
		{
		  x			=		ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
		  y		=		ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
		  x			=		x.replace(/^\s+|\s+$/g,"");
		  if (x==content)
		  {
			  return unescape(y);
		  }
		}
	},
	gethighestcpm	:	function()
	{
		var i,x,y,ARRcookies	=		document.cookie.split(";");
		content						= 		"highestcpm";
		for (i=0;i<ARRcookies.length;i++)
		{
		  x			=		ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
		  y		=		ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
		  x			=		x.replace(/^\s+|\s+$/g,"");
		  if (x==content)
		  {
			  return unescape(y);
		  }
		}
	},
	getgoal	:	function()
	{
		var i,x,y,ARRcookies	=		document.cookie.split(";");
		content						= 		"goal";
		for (i=0;i<ARRcookies.length;i++)
		{
		  x			=		ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
		  y		=		ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
		  x			=		x.replace(/^\s+|\s+$/g,"");
		  if (x==content)
		  {
			  return unescape(y);
		  }
		}
	},
	sethighestctr	:	function(cook)
	{
		document.cookie="highestctr" + "=" + cook;
	},
	sethighestcpc	:	function(cook)
	{
		document.cookie="highestcpc" + "=" + cook;
	},
	sethighestcpm	:	function(cook)
	{
		document.cookie="highestcpm" + "=" + cook;
	},
	setgoal	:	function(cook)
	{
		document.cookie="goal" + "=" + cook;
	}
};

