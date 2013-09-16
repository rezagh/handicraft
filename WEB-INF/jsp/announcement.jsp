	<script type='text/javascript' src='dwr/interface/DwrFrontController.js'></script>
  	<script type='text/javascript' src='dwr/engine.js'></script>
	<script type='text/javascript' src='dwr/util.js'></script>


<script>
	j = 0;
	$(document).ready(function() {
		dwr.util.setEscapeHtml(false);
		DwrFrontController.getAnnouncements(function(items) { window.setInterval(function showAnn(){
			i = items.length;
			//alert(items[j].title);
			document.getElementById('ann').innerHTML =items[j].title;
			  //$('#ann').val(items[j].title) 
			j++;
			if(j>=i) j=0;
			},3000); });
  	});

	
</script>

<span id="ann" class="ann"></span>


		    