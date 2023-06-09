$(document).ready(function () {
    $(".count").counterUp({delay: 10, time: 5000});
    (function (a) {
        var b = a(".client-slider");
        if (b.length > 0) {
            b.owlCarousel({
                margin: 0,
                loop: false,
                nav: true,
                center: false,
                dots: false,
                autoplay: true,
                autoplayTimeout: 5000,
                items: 2,
                responsiveClass: true,
                navText: ['<span class="mdi mdi-arrow-left"></span>', '<span class="mdi mdi-arrow-right"></span>'],
                responsive: {
                    0: {items: 1, nav: false,},
                    600: {items: 1, nav: false,},
                    1000: {items: 2, nav: false,},
                    1200: {items: 2, nav: true,}
                }
            })
        }
    })(jQuery);
    (function (a) {
        a("#menu > li a").on("click", function () {
            a("#main-wrapper > section.active, #menu > li a").removeClass("active");
            a(this).addClass("active");
            var d = a(this).attr("href");
            a("#main-wrapper").children(d).addClass("active");
            var b = a(".portfolio-items");
            var c = a("#portfolio-filter");
            b.isotope({filter: "*", layoutMode: "masonry", animationOptions: {duration: 750, easing: "linear"}});
            c.find("a").on("click", function () {
                var e = a(this).attr("data-filter");
                c.find("a").removeClass("active");
                a(this).addClass("active");
                b.isotope({
                    filter: e,
                    animationOptions: {animationDuration: 750, easing: "linear", queue: false, touchSensitivity: 2,}
                });
                return false
            })
        })
    })(jQuery);
    (function (a) {
        var c = a(".menu-toggler");
        var d = a(window);
        var b = a("header");
        c.click(function () {
            a(this).toggleClass("open").find("i").toggleClass("mdi-menu mdi-close ");
            b.toggleClass("open")
        });
        if (d.width() < 992) {
            a(".menu-list li a").click(function () {
                b.removeClass("open");
                c.removeClass("open").find("i").removeClass("mdi-close").addClass("mdi-menu")
            })
        }
    })(jQuery);
    if ((".portfolio-items").length > 0) {
        $(".portfolio-items").each(function () {
            $(this).magnificPopup({delegate: ".js-zoom-gallery", type: "image", gallery: {enabled: true}})
        })
    }
});
(function (a) {
    a(window).on("load", function () {
        var c = 500;

        function b() {
            var d = a(".spinner-wrapper");
            setTimeout(function () {
                d.fadeOut(c)
            }, 500)
        }

        b()
    })
})(jQuery);
$(".menu-close-btn").on("click", function () {
    $(".navbar-collapse").removeClass("show")
}), (function (a) {
    var b = jQuery(window).width();
    if ((b) > "992") {
        particlesJS.load("particles-js", "particles.json", function () {
        });
        particlesJS.load("particles-js1", "particles.json", function () {
        })
    }
})(jQuery);