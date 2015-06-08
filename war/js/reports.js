$(document).ready(function()
{
	$.get('reportgen',function(data)
	{
       	 var jsonvars				=	JSON.parse(data);
       	 console.log("ui");
       	 console.log(jsonvars);
      	  	dtable = $('#datastables').dataTable({
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
			dtable.fnClearTable();
			
			dtable_initial = $('#initial').dataTable({
				"bDestroy" : true,
				"aoColumns" : [{
					"sTitle" : "Click",
					"sWidth" : "25%",
					"sClass" : "center"
				},{
					"sTitle" : "Impressions",
					"sWidth" : "25%",
					"sClass" : "center"
				},{
					"sTitle" : "Cost to an Advertiser",
					"sWidth" : "25%",
					"sClass" : "center"
				},{
					"sTitle" : "Conversions",
					"sWidth" : "25%",
					"sClass" : "center"
				}]
			});
			dtable_initial.fnClearTable();	
			
			var newRow = [];
			var initial = [];
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
				initial[0] = jsonvars[index].clicks;
				initial[1] = jsonvars[index].impresssions;
				initial[2] = jsonvars[index].advertisers;
				initial[3] = jsonvars[index].conversions;
				dtable.fnAddData(newRow);
				dtable_initial.fnAddData(initial);
			}
				dtable.fnDraw();
				dtable_initial.fnDraw();
				$('#main').show();
				$('#loading').hide();
	});
});
