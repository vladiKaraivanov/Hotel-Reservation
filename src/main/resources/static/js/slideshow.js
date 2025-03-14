// Отваряне на lightbox
function openLightbox(imgElement) {
    var lightbox = document.getElementById("lightbox");
    var lightboxImg = document.getElementById("lightbox-img");

    lightbox.style.display = "block";
    lightboxImg.src = imgElement.src;
}

// Затваряне на lightbox
function closeLightbox() {
    document.getElementById("lightbox").style.display = "none";
}
