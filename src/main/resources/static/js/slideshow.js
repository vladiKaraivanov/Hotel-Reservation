document.addEventListener('DOMContentLoaded', function() {
    // Вашият код за управление на слайдшоуто може да отиде тук
    let slideIndex = 0;
    function changeSlide(step) {
        const slides = document.querySelectorAll('.slideshow .image');
        slideIndex += step;
        if (slideIndex >= slides.length) {
            slideIndex = 0;
        } else if (slideIndex < 0) {
            slideIndex = slides.length - 1;
        }
        slides.forEach(slide => slide.style.display = 'none');
        slides[slideIndex].style.display = 'block';
    }

    // Тук добавете обработчици за клик събития към стрелките
    document.querySelector('.prev').addEventListener('click', () => changeSlide(-1));
    document.querySelector('.next').addEventListener('click', () => changeSlide(1));
});
