import{r as u,o as m,b as c,d as e,v as l,x as r,y as p,q as f,m as a,z as g}from"./index-yeZGxvQv.js";import{a as b}from"./axios-Cm0UX6qg.js";import{u as x}from"./index-BiQEVG5M.js";const w={BASE_URL:"/",MODE:"development",DEV:!0,PROD:!0},v={class:"h-screen w-full flex justify-center items-center"},y={class:"w-1/2 xl:w-1/4"},_={class:"bg-white p-8 rounded-lg shadow-lg min-w-full"},h=e("h1",{class:"text-center text-2xl mb-6 text-gray-600 font-bold font-sans"},"注册",-1),k=e("label",{class:"text-gray-800 font-semibold block my-3 text-md",for:"username"},"Username",-1),U=e("label",{for:"default",class:"block mb-2 text-sm font-medium text-gray-900 dark:text-white"},"Organization",-1),z=e("option",{value:"校内人员"},"校内人员",-1),R=e("option",{value:"校外人员",selected:""},"校外人员",-1),E=[z,R],S=e("label",{class:"text-gray-800 font-semibold block my-3 text-md",for:"password"},"Password",-1),V=e("label",{class:"text-gray-800 font-semibold block my-3 text-md",for:"confirm"},"Confirm password",-1),L={__name:"Register",setup(B){const t=u({username:"",password:"",organization:""}),d=x(),i=()=>{const n=/^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$/,o=/^[a-zA-Z0-9]{4,16}$/;if(!n.test(t.value.username)){a.error({message:"用户名格式不正确"});return}if(!o.test(t.value.password)){a.error({message:"密码格式不正确"});return}if(t.value.password!==t.value.confirm){a.error({message:"两次密码不一致"});return}b.post(w.BASE_URL+"/register",t.value).then(s=>{s.data.code===200401?a.error({message:s.data.data}):s.data.code===200200&&(localStorage.setItem("user",s.data.data),d.updateUserInfo(s.data.data),a.success({message:s.data.msg}),g.push("/"))}).catch(s=>{console.log(s)})};return(n,o)=>(m(),c("div",v,[e("div",y,[e("div",_,[h,e("div",null,[k,l(e("input",{class:"w-full bg-gray-100 px-4 py-2 rounded-lg focus:outline-none",type:"text",name:"username","onUpdate:modelValue":o[0]||(o[0]=s=>t.value.username=s),id:"username",placeholder:"username"},null,512),[[r,t.value.username]])]),e("div",null,[U,l(e("select",{name:"organization",id:"default","onUpdate:modelValue":o[1]||(o[1]=s=>t.value.organization=s),class:"bg-gray-50 border border-gray-300 text-gray-900 mb-6 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"},E,512),[[p,t.value.organization]])]),e("div",null,[S,l(e("input",{class:"w-full bg-gray-100 px-4 py-2 rounded-lg focus:outline-none",type:"password",name:"password","onUpdate:modelValue":o[2]||(o[2]=s=>t.value.password=s),id:"password",placeholder:"password"},null,512),[[r,t.value.password]])]),e("div",null,[V,l(e("input",{class:"w-full bg-gray-100 px-4 py-2 rounded-lg focus:outline-none",type:"password",name:"confirm","onUpdate:modelValue":o[3]||(o[3]=s=>t.value.confirm=s),id:"confirm",placeholder:"confirm password"},null,512),[[r,t.value.confirm]])]),e("button",{type:"submit",onClick:f(i,["prevent"]),class:"w-full mt-6 bg-indigo-600 rounded-lg px-4 py-2 text-lg text-white tracking-wide font-semibold font-sans"}," Register && Login ")])])]))}};export{L as default};