
function loadCountriesFrom() {
	console.log("loadCountriesFrom");
	 $.ajax({  
            type: "GET",  
            url: "rest/sambaws/countries",  
            data: "",
            dataType: "json",                  
            success: function( result )
            {  
            	var $select = $('#countryFrom'); 

            	var countries = JSON.stringify(result);
            	var jsonResult = JSON.parse(countries);
                
                for (var i in jsonResult) {
                	$select.append('<option value=' + jsonResult[i].id + '>' + jsonResult[i].name+ '</option>');
                }
            },  
            error: function( result )
            {
                console.log("cannot load countries");
            }
        });    

}


function loadCountriesTo() {
	console.log("loadCountriesTo");
	 $.ajax({  
            type: "GET",  
            url: "rest/sambaws/countries",  
            data: "",
            dataType: "json",                  
            success: function( result )
            {  
            	var $select = $('#countryTo'); 

            	var countries = JSON.stringify(result);
            	var jsonResult = JSON.parse(countries);
                
                for (var i in jsonResult) {
                	$select.append('<option value=' + jsonResult[i].id + '>' + jsonResult[i].name+ '</option>');
                }
            },  
            error: function( result )
            {
                console.log("cannot load countries");
            }
        });    

}



function loadCitiesFrom() {
	console.log("loadCitiesFrom");
	var selectedCountryIdFrom = $('#countryFrom option:selected').val();
	 $.ajax({  
            type: "GET",  
            url: "rest/sambaws/cities?countryId="+selectedCountryIdFrom,  
            data: "",
            dataType: "json",                  
            success: function( result )
            {  
            	var $select = $('#cityFrom'); 

            	var cities = JSON.stringify(result);
            	var jsonResult = JSON.parse(cities);
                
                for (var i in jsonResult) {
                	$select.append('<option value=' + jsonResult[i].id + '>' + jsonResult[i].name+ '</option>');
                }
            },  
            error: function( result )
            {
                console.log("cannot load countries");
            }
        }); 

}
        function loadCitiesTo() {
        	console.log("loadCitiesTo");
        	var selectedCountryIdTo = $('#countryTo option:selected').val();
	 $.ajax({  
            type: "GET",  
            url: "rest/sambaws/cities?countryId="+selectedCountryIdTo,  
            data: "",
            dataType: "json",                  
            success: function( result )
            {  
            	var $select = $('#cityTo'); 

            	var cities = JSON.stringify(result);
            	var jsonResult = JSON.parse(cities);
                
                for (var i in jsonResult) {
                	$select.append('<option value=' + jsonResult[i].id + '>' + jsonResult[i].name+ '</option>');
                }
            },  
            error: function( result )
            {
                console.log("cannot load countries");
            }
        });       

}


function formToJSON() {
		var selectedCountryIdTo = $('#countryTo option:selected').val();
		var selectedCountryIdFrom = $('#countryFrom option:selected').val();
		var selectedCityIdTo = $('#cityTo option:selected').val();
		var selectedCityIdFrom = $('#cityFrom option:selected').val();

return JSON.stringify({
				"fromCountryId": selectedCountryIdFrom,
				"fromCityId": selectedCityIdFrom,
				"toCountryId": selectedCountryIdTo,
				"toCityId": selectedCityIdTo,
				"mail": $('#email').val(),
				"name": $('#name').val(),
				"dimensions" : "[{"+"width:"+$('#widthBag').val()+",height:"+$('#heightBag').val()+",lenght:"+$('#lengthBag').val()+",weight:"+$('#weightBag').val()+"}]"
});
}



        function getQuotation() {
        	console.log("getQuotation");
        
	 										$.ajax({  
            type: "POST",  
            url: "rest/sambaws/quotation",  
            data: formToJSON(),
            dataType: "json",                  
            success: function( result )
            {  

            	var quotationResponse = JSON.stringify(result);
            	var jsonResult = JSON.parse(quotationResponse);
            	// set values
            	$("#quotationResponseCountryCityFrom").html(jsonResult.fromCityName + ","+jsonResult.fromCountryName);
            	$("#quotationResponsecountryCityTo").html(jsonResult.toCityName+ ","+jsonResult.toCountryName);
            	$("#quotationResponseWeight").html( jsonResult.dimensions[0].weight + " "+ jsonResult.dimensions[0].weightUnit);
            	$("#quotationResponsePrice").html(jsonResult.dimensions[0].price + " "+ jsonResult.dimensions[0].currency);
            },  
            error: function( result )
            {
                console.log("cannot get quotations");
            }
        });       

}

$(window).ready( function() {
	console.log("devis start");
    loadCountriesFrom();
    loadCountriesTo();

    $("#countryFrom").change(function() {
 					loadCitiesFrom();
	     });

    $("#countryTo").change(function() {
 				loadCitiesTo();
	     });

    $("#computequotation").click(function() {
 				getQuotation();
	     });
    
});