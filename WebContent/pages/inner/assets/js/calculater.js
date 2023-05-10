document.getElementById("calculatortextid").value = "";
var valueFirstOpe = document.getElementById("calculatortextis").value;
function valueIdc() {
	document.getElementById("calculatortextid").value = "";
}
function valueIdxsquare() {
	if (document.getElementById("calculatortextid").value != "") {
		var valueFirst = Number(document.getElementById("calculatortextid").value);

		document.getElementById("calculatortextid").value = valueFirst
				* valueFirst;
	}

}
function valueIdroot() {
	if (document.getElementById("calculatortextid").value != "") {
		document.getElementById("calculatortextid").value = Math
				.sqrt(Number(document.getElementById("calculatortextid").value));
	}
}
function valueIdmod() {
	document.getElementById("calculatortextid").value += "%";
}
function valueId7() {
	document.getElementById("calculatortextid").value += "7";
}

function valueId8() {
	document.getElementById("calculatortextid").value += "8";
}
function valueId9() {
	document.getElementById("calculatortextid").value += "9";
}
function valueIddivision() {
	document.getElementById("calculatortextid").value += "/";
}
function valueId4() {
	document.getElementById("calculatortextid").value += "4";
}
function valueId5() {
	document.getElementById("calculatortextid").value += "5";
}
function valueId6() {
	document.getElementById("calculatortextid").value += "6";
}
function valueIdmultiply() {
	document.getElementById("calculatortextid").value += "*";
}
function valueId1() {
	document.getElementById("calculatortextid").value += "1";
}
function valueId2() {
	document.getElementById("calculatortextid").value += "2";
}
function valueId3() {
	document.getElementById("calculatortextid").value += "3";
}
function valueIdminus() {
	document.getElementById("calculatortextid").value += "-";
}
function valueId0() {
	document.getElementById("calculatortextid").value += "0";
}
function valueIddot() {
	document.getElementById("calculatortextid").value += ".";
}
function valueIdplus() {

	document.getElementById("calculatortextid").value += "+";
}
function valueIdequal() {

	document.getElementById("calculatortextid").value = eval(document
			.getElementById("calculatortextid").value);

}