

/*$(document).ready(function(){
	
	$("blog").hide();
});*/
//$("#blog").slideUp(1000).slideDown(1000);
function initMap() {
	var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 13,
        center: {lat: 20.351156, lng: 85.800261}
      });
	marker = new google.maps.Marker({
		map : map,
		draggable : true,
		animation : google.maps.Animation.DROP,
		position : {
			lat : 20.351156,
			lng : 85.800261
		}
	});
	marker.addListener('click', toggleBounce);
    
}

function toggleBounce() {
	if (marker.getAnimation() !== null) {
		marker.setAnimation(null);
	} else {
		marker.setAnimation(google.maps.Animation.BOUNCE);
	}
}
