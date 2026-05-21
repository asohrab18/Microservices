window.onload = function () {

    const queryString = window.location.search;
    const homeBtn = document.getElementById("homeBtn");

	if (homeBtn) {
        homeBtn.href = "/home" + queryString;
    }
};