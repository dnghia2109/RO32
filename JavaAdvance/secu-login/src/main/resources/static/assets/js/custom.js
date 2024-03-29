// jQuery(document).ready(function ($) {
//     "use strict";
//
//     $(window).scroll(function () {
//         let scroll = $(window).scrollTop();
//         let box = $('.header-text').height();
//         let header = $('header').height();
//
//         if (scroll >= box - header) {
//             $("header").addClass("background-header");
//         } else {
//             $("header").removeClass("background-header");
//         }
//     });
//
//     // Active menu
//     const menuEls = document.querySelectorAll("#navbarResponsive li");
//
//     const activeMenu = () => {
//         let path = window.location.pathname;
//
//         Array.from(menuEls).map(e => e.classList.remove("active"));
//         menuEls.forEach(e => {
//             if(e.firstElementChild.getAttribute("href") === path) {
//                 e.classList.add("active")
//             }
//         })
//     }
//
//     activeMenu();
//
//
// });

jQuery(document).ready(function ($) {
    "use strict";

    $(window).scroll(function () {
        let scroll = $(window).scrollTop();
        let box = $('.header-text').height();
        let header = $('header').height();

        if (scroll >= box - header) {
            $("header").addClass("background-header");
        } else {
            $("header").removeClass("background-header");
        }
    });
});

// Active menu
const activeMenu = () => {
    const menuEls = document.querySelectorAll("#navbarResponsive > li");
    let path = window.location.pathname;

    menuEls.forEach(menu => {
        const menuItemEls = menu.querySelectorAll(".nav-treeview a");
        menuItemEls.forEach(menuItem => {
            if(menuItem.getAttribute("href") === path) {
                menuItem.classList.add("active");
                menu.firstElementChild.classList.add("active")
                menu.classList.add("menu-is-opening", "menu-open")
            }
        })
    })
}
activeMenu();

const btnLogout = document.getElementById("btn-logout");
btnLogout.addEventListener("click", async (e) => {
    try {
        let res = await axios.post("/api/v1/admin/logout")

        if(res.status === 200) {
            toastr.success("Đăng xuất thành công");
            setTimeout(() => {
                window.location.href = "/admin/login"
            }, 1500)
        }
    } catch (e) {
        toastr.error("Đăng xuất thất bại");
        console.log(e)
    }
})
