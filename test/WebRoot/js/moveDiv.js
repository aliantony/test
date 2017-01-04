var MoveDiv = function() {
};

MoveDiv.Move = function(moveid) {
	var movediv = document.getElementByIdx_x(moveid);

	var childDiv = movediv.getElementsByTagName_r("div");
	var NodeLen = childDiv.length;
	if (NodeLen != 0) {
		for ( var j = 0; j < NodeLen; j++) {

			if (j == 0) {

				childDiv[j].onselectstart = function() {
					return false;
				};

				childDiv[j].onmousedown = function(e) {
					e = e || window.event;
					var x = e.layerX || e.offsetX;

					var y = e.layerY || e.offsetY;

					document.onmousemove = function(e) {
						e = e || window.event;
						movediv.style.left = (e.clientX - x) + "px";
						movediv.style.top = (e.clientY - y) + "px";
					};

					document.onmouseup = function() {
						document.onmousemove = null;
					};
				};
			}

			else {
				childDiv[j].onmousedown = function() {
					return false;
				};

				childDiv[j].onselectstart = function() {
					return true;
				};
			}
		}
	}

}
