/* ==============================================
Google Map
=============================================== */
function initialize() {
	
	"use strict";
	
	var mapProp = {
  		center:new google.maps.LatLng(40.758440, -73.985186), 		// <- Your LatLng
  		zoom:16,
		scrollwheel: false,
  		mapTypeId:google.maps.MapTypeId.ROADMAP
  	};
	var map = new google.maps.Map(document.getElementById("map"),mapProp);
}
google.maps.event.addDomListener(window, 'load', initialize);

/* ==============================================
jQuery
=============================================== */
$(document).ready(function () {
	
	"use strict";
	
	// ascensor initialize
	//$('#ascensor').ascensor({ascensorMap: [[1,1],[0,0],[0,1],[0,2],[1,2],[1,0],[2,0],[2,1],[2,2]]});					 // Ascensor
	//$('#ascensor').ascensor({ascensorMap: [[1,1],[0,0],[0,1],[0,2],[1,2],[1,0],[2,0],[2,1],[2,2]], queued: true});	// Ascensor Queued
	$('#ascensor').ascensor({ascensorMap: [[0,0],[0,1],[0,2],[0,3],[0,4],[0,5],[0,6],[0,7],[0,8]]}); 					// Horizontal
	//$('#ascensor').ascensor({ascensorMap: [[0,0],[1,0],[2,0],[3,0],[4,0],[5,0],[6,0],[7,0],[8,0]]});					// Vertical
	
	// load tweets
	$(".follow .load-tweets").load("php/twitter.php");
	
	$("[href='#']").click(function(e){
		e.preventDefault();
	});
	
	// show, hide navbar
	$(".tile").click(function(){
		$(".navbar").animate({bottom:0},"slow");
	}); 
	$(".home-link").click(function(){
		$(".navbar").animate({bottom:-50},"slow");
	}); 

	// navbar-callapse close on click
	$('.navbar li a').on('click',function(){
		if ( $('.navbar-collapse').hasClass("in") ) {
			$('.navbar-collapse').collapse('hide');
		}
	})
	
	$("#about-carousel").carousel({interval: 2000});
	
	// portfolio
	$("#grid").mixitup();
	
	// portfolio hover
	$("#grid li a ").each(function() { 
		$(this).hoverdir(); 
	});

	// center box
	function centerBox(){
		
		"use strict";
		
		var wHeight = $(window).height() ;
		$(".section .center-box").each(function() {
			var paddingTop =  $(this).height() ;
			if ( paddingTop < wHeight ) {
				paddingTop = ( wHeight - paddingTop ) / 2;
				$(this).css("padding-top",paddingTop);
			} else {
				$(this).css("padding-top","0");
			}
		});
	};
	
	$(window).resize(function(){
		centerBox();
	}).resize();

	// contact form
	$('input, textarea').placeholder();
	
	$('#contactform').submit(function(){
	
		"use strict";
		
		var action = $(this).attr('action');
		
		$("#state-message").slideUp(750,function() {
		$('#state-message').hide();
		
		$.post(action, { 
			name: $('#name').val(),
			email: $('#email').val(),
			message: $('#message').val()
		},
			function(data){
				document.getElementById('state-message').innerHTML = data;
				$('#state-message').slideDown('slow');
				$('#contactform img.loader').fadeOut('slow',function(){$(this).remove()});
				$('#submit').removeAttr('disabled'); 
				if(data.match('success') != null) $('#contactform').slideUp('slow');
			}
		);
		});
		return false; 
	});

});

/* ==============================================
Testimonials
=============================================== */

jQuery(function( $ ){
	
	"use strict";
	
	var randomnumber, quoteclass, author, timeout;
	
	startTestimonials();
	
	$('.client .photos ul li').hover( function(){

		window.clearTimeout(timeout);
		
		$('.client .photos ul li.active').removeClass('active');
		
		quoteclass = $(this).attr('class');
		
		author = $(this).find('img').attr('alt');
		author = author.split('-');
		author = author[0] + '<span> - ' + author[1] + '</span>';
		
		$('.client .quotes ul li.active').fadeOut('slow', function(){
			$(this).removeClass('active');
			$('.client .quotes ul li.' + quoteclass).fadeIn().addClass('active');
			$('.client .photos .author').html(author);
		});
		
		$(this).addClass('active');
		
	}, function(){
		timeout = window.setTimeout( startTestimonials, 5000 );
		return false;
	});
	
	function startTestimonials() {
		
		"use strict";
		
		$('.client .photos ul li.active').removeClass('active');
		
		randomnumber = Math.floor( (Math.random()*6) + 1 );
		
		author = $('.client .photos ul li.quote-' + randomnumber).find('img').attr('alt');
		author = author.split('-');
		author = author[0] + '<span> - ' + author[1] + '</span>';
		
		$('.client .quotes ul li.active').fadeOut('slow', function(){
			$(this).removeClass('active');
			$('.client .quotes ul li.quote-' + randomnumber).fadeIn().addClass('active');
			$('.client .photos .author').html(author);
		});
		
		$('.client .photos ul li.quote-' + randomnumber).addClass('active');
		
		timeout = window.setTimeout( startTestimonials, 5000 );
	}
	
});

/* ==============================================
Samba Express BEGIN
=============================================== */
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
            error: function( jqXHR, textStatus, errorThrown )
            {
                console.log("cannot load countries"+textStatus);
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
            error: function( jqXHR, textStatus, errorThrown )
            {
                console.log("cannot load countries"+textStatus);
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
            error: function( jqXHR, textStatus, errorThrown )
            {
                console.log("cannot load countries"+textStatus);
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
            error: function( jqXHR, textStatus, errorThrown )
            {
                console.log("cannot load countries"+textStatus);
            }
        });       

}


function formToJSON() {
		var selectedCountryIdTo = $('#countryTo option:selected').val();
		var selectedCountryIdFrom = $('#countryFrom option:selected').val();
		var selectedCityIdTo = $('#cityTo option:selected').val();
		var selectedCityIdFrom = $('#cityFrom option:selected').val();
		var mail = $('#email').val();
		var name = $('#name').val();
		
		var result = '{'+'"fromCountryId":'+selectedCountryIdFrom+',"fromCityId":'+selectedCityIdFrom+',"toCountryId":'+selectedCountryIdTo+',' +
		'"toCityId":'+selectedCityIdTo+',"mail":"'+mail+'","name":"'+name+'","dimensions":'+'[{"width":'+$('#widthBag').val()+',"height":'+$('#heightBag').val()+
		',"lenght":'+$('#lengthBag').val()+',"weight":'+$('#weightBag').val()+',"weightUnit":"'+$('#weightRadio').val()+'"}]'+ 
		'}';

		return result;
}





        function getQuotation() {
        	console.log("getQuotation");
        	
        	$('#loading').html('<img src="http://preloaders.net/preloaders/287/Filling%20broken%20ring.gif">');
        	
        	var selectedCityFromText = $('#cityFrom').find('option:selected').text();

        	if(selectedCityFromText == 'Ville de Départ') {
        		return
        	}
        	
        	
        	var selectedCityToText = $('#cityTo').find('option:selected').text();
        	
        	if( selectedCityToText == 'Ville d\'Arrivée') {
        		return
        	}
        
	 $.ajax({  
            type: "POST", 
            contentType: "application/json",
            url: "rest/sambaws/quotation",  
            data: formToJSON(),
            dataType: "json",                  
            success: function( result )
            {  

            	var quotationResponse = JSON.stringify(result);
            	var jsonResult = JSON.parse(quotationResponse);
            	// set values
            	$("#quotationResponseFrom").html(jsonResult.fromCityName + ","+jsonResult.fromCountryName);
            	$("#quotationResponseTo").html(jsonResult.toCityName+ ","+jsonResult.toCountryName);
            	$("#quotationResponseWeight").html( jsonResult.dimensions[0].weight + " "+ jsonResult.dimensions[0].weightUnit);
            	$("#quotationResponsePrice").html(jsonResult.dimensions[0].price + " "+ jsonResult.dimensions[0].currency);
            	
            	//trigger modal for quotation
            	$('#quotationResponse').css('display','block');
            	$("body").addClass("modal-open");
            	$("#quotationResponse").addClass("in");
            	$( "<div class=\"modal-backdrop fade in\"></div>" ).insertAfter( $( "script:last" ) );
            	
            	
            },  
            error: function( jqXHR, textStatus, errorThrown )
            {
                console.log("cannot get quotations"+textStatus);
            }
        });       

}




/* ==============================================
Samba Express BEGIN
=============================================== */

/* ==============================================
Loading
=============================================== */
$(window).load(function(){
	"use strict";
	jQuery('#loading').fadeOut(1000);
	
	// samba express
	
	console.log("devis start");
    loadCountriesFrom();
    loadCountriesTo();

    $("#countryFrom").change(function() {
    	
    	var selectedCountryFromText = $('#countryFrom').find('option:selected').text();

    	if(selectedCountryFromText != 'Pays de Départ') {
    		loadCitiesFrom();
    	}
 					
	     });

    $("#countryTo").change(function() {
    	var selectedCountryToText = $('#countryTo').find('option:selected').text();
    	
    	if(selectedCountryToText != 'Pays d\'Arrivée' ) {
    		loadCitiesTo();
    	}
 				
	     });

    $("#computequotation").click(function() {
 				getQuotation();
	     });
    
    
    $("#quotationBoxCloseButon").click(function() {
    	//trigger modal for quotation
    	$('#quotationResponse').removeAttr( 'style' );
    	$("body").removeClass("modal-open");
    	$( ".modal-backdrop" ).remove();
    	$("#quotationResponse").removeClass("in");
    	
    	
    	// reset quotation fields
    	
    	$('#name').val('');
    	$('#tel').val('');
    	$('#email').val('');
    	
    	$('#lengthBag').val('Longeur Baggage1 (cm/pouces)');
    	$('#widthBag').val('Largeur Baggage1 (cm/pouces)');
    	$('#heightBag').val('Hauteur Baggage1 (cm/pouces)');
    	$('#weightBag').val('Poids Baggage1');
    	
    	//$('#countryTo option:selected').text('Pays d\'Arrivée');
    	//$('#cityTo option:selected').text('Ville d\'Arrivée');
    	
    	$('#countryTo').val("").attr("selected", "selected");
    	$('#cityTo').val("").attr("selected", "selected");
    	
    	$('#countryFrom').val("").attr("selected", "selected");
    	$('#cityFrom').val("").attr("selected", "selected");
    	
		//$('#countryFrom option:selected').text('Pays de Départ');
		//$('#cityFrom option:selected').text('Ville de Départ');
    });
    
    
    // End samba express
});