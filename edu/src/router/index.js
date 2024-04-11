import {createRouter, createWebHistory} from "vue-router";


const routes = [
    {
        path: "/",
        name: "Home",
        component: () => import("../views/Home.vue"),
        redirect: "/HomeView",
        children: [
            {
                path: "HomeView",
                name: "HomeView",
                component: () => import("../views/HomeView.vue")
            },
            {
                path: "booking",
                name: "Booking",
                component: () => import("../views/Booking.vue")
            },
            {
                path: "/detail/:activity_id",
                name: "Detail",
                component: () => import("../views/Detail.vue")
            },
            {
                path: "/geography",
                name: "Geography",
                component: () => import("../views/Geography.vue")
            },
            {
                path: "browse",
                name: "Browse",
                component: () => import("../views/Browse.vue")
            },
            {
                path: "order",
                name: "Order",
                component: () => import("../views/Order.vue")
            },
            {
                path: "orderDetail",
                name: "OrderDetail",
                component: () => import("../views/OrderDetail.vue")
            }
        ]
    },
    {
        path: "/about",
        name: "About",
        component: () => import("../views/About.vue")
    },
    {
        path: "/login",
        name: "Login",
        component: () => import("../views/Login.vue")
    },
    {
        path: "/register",
        name: "Register",
        component: () => import("../views/Register.vue")
    },
    {
        path: "/404",
        name: "404",
        component: () => import("../views/404.vue")
    },
    {
        path: "/:pathMatch(.*)*",
        redirect: "/404"
    }
]


const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes
})


export default router;
