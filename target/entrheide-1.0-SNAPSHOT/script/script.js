function changeStar(){
    var x = document.getElementById("star");
    var v = x.getAttribute("src");
    if (v=="img/star.png")
    {v="img/starL.png"}
    else
    {v="img/star.png"}
    x.src=v;
}
function afficherCacher() {

    if (document.getElementById('cat').style.display == 'none' ) {
        document.getElementById('cat').style.display = 'block';
        document.getElementById("voir").src="img/voirMoin.png";
    }
    else {
        document.getElementById('cat').style.display = 'none';
        document.getElementById("voir").src="img/voirPlus.png";
    }

}

