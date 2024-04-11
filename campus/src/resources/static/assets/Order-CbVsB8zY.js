import{_ as B}from"./images2-DJjKTlpM.js";import{u as E}from"./index-BiQEVG5M.js";import{r as g,m as j,s as N,a as r,o as i,b as f,d as e,f as n,F as w,h as k,w as l,i as U,j as I,t as c,k as h,u as y,g as F,l as T}from"./index-yeZGxvQv.js";import{a as z}from"./axios-Cm0UX6qg.js";const R={class:"max-w-[80%] mx-auto"},L=e("div",{class:"mx-auto h-2"},null,-1),A=e("div",{class:"mx-auto max-w-[80%] bg-white"},null,-1),G=e("div",{class:"mx-auto h-2"},null,-1),H={class:"mx-auto max-w-[80%] bg-white"},J=e("div",{class:"flex flex-col justify-center px-6"},[e("span",{class:"w-fit text-4xl font-sans leading-relaxed text-transparent bg-clip-text bg-gradient-to-r to-emerald-600 from-sky-400"},"查看用户订单")],-1),K={class:"flex flex-col justify-center px-6"},P={class:"flex min-h-screen justify-center overflow-hidden py-6 sm:py-12"},Q={class:"mx-auto max-w-screen-xl px-4 w-full"},W=e("h2",{class:"mb-4 text-center text-gray-500 font-bold text-md"},null,-1),X={class:"flex w-full justify-start py-2 px-6"},Z=e("label",{class:"text-center p-2"},"当前查询日期",-1),ee={class:"w-full overflow-x-hidden"},te={class:"flex justify-between"},se={class:"text-gray-600 text-sm"},ae={class:"text-blue-600 cursor-pointer flex items-center"},le={class:"w-full flex"},oe=["src","onClick"],ne={class:"w-full"},re=U('<div class="mx-auto max-w-[80%] bg-white"><div class="flex justify-center py-6 px-6"><img class="w-full min-h-10" src="'+B+'" alt=""></div></div><div class="mx-auto h-5"></div><div class="mx-auto max-w-[80%] bg-white"><div class="mx-auto w-full max-w-screen-xl"><div class="px-4 py-6 bg-gray-100 md:flex md:items-center md:justify-between"><span class="text-sm text-gray-500 sm:text-center">© 2024 <a href="#">校园日预约购票系统</a></span></div></div></div>',3),ie={class:"flex justify-between"},ce={class:"text-red-600"},de={class:"w-full h-10 line-clamp-2 text-ellipsis"},ue={class:"cursor-pointer"},_e={class:"my-5"},pe=["src"],me={class:"cursor-pointer"},fe={class:"dialog-footer"},be={__name:"Order",setup(he){const v=E(),C=F(),d=g("2024-06-15"),m=g(!1),D=g({}),x=g([]);z.get(`/api/auth/getUserOrderDetail?date=${d.value}&username=${v.userInfo.username}&phone=${v.userInfo.phone}`).then(a=>{a.data.code===200200?(j.info("查询订单成功"),x.value=a.data.data,console.log("/auth/getUserOrder",a.data.data),x.value.forEach(s=>{const u=new Map,_=[];return s.activities.forEach(o=>{if(!u.has(o.id))return u.set(o.id,!0),_.push(o),o}),s.activities=_}),console.log(x.value)):(console.log(a.data),j.error("查询订单失败,请先预约"))}).catch(a=>{console.log(a)}),N({render(){return T("p","当前查询的日期为: ")}});const b=a=>{const s=new Date(a),u=s.getFullYear(),_=String(s.getMonth()+1).padStart(2,"0"),o=String(s.getDate()).padStart(2,"0");return`${u}-${_}-${o}`},S=a=>b(a)<b(new Date)||b(a)!=="2024-06-15",Y=()=>{},M=a=>{m.value=!0,D.value=a};return(a,s)=>{const u=r("el-date-picker"),_=r("el-image"),o=r("el-text"),V=r("el-card"),O=r("el-row"),$=r("el-button"),q=r("el-dialog");return i(),f(w,null,[e("div",R,[L,A,G,e("div",H,[J,e("div",K,[e("div",P,[e("div",Q,[W,e("div",X,[Z,n(u,{class:"min-w-[300px]",onChange:Y,modelValue:d.value,"onUpdate:modelValue":s[0]||(s[0]=t=>d.value=t),type:"date",format:"YYYY-MM-DD","disabled-date":S,"value-format":"YYYY-MM-DD",placeholder:"选择日期",size:"large"},null,8,["modelValue"])]),e("div",ee,[(i(!0),f(w,null,k(x.value,t=>(i(),I(V,{shadow:"hover",key:t.id},{header:l(()=>[e("div",te,[e("span",se,c(d.value)+" "+c(t.startTime)+" - "+c(t.endTime)+" 活动预约",1),e("span",null,c(t.organization),1),e("span",ae,[h("入校预约二维码 "),n(_,{class:"w-10 h-10",src:t.qrCode,"preview-src-list":[t.qrCode]},null,8,["src","preview-src-list"])])])]),default:l(()=>[e("div",le,[(i(!0),f(w,null,k(t.activities,p=>(i(),f("span",{class:"p-2",key:p.id},[e("img",{class:"w-20 h-20",src:p.images,onClick:ve=>y(C).push({path:"/orderDetail",query:{activityId:p.id,userId:y(v).userInfo.id,date:d.value,title:p.title}})},null,8,oe)]))),128))]),e("div",ne,[n(o,{onClick:p=>M(t),type:"info",class:"cursor-pointer hover:text-blue-600"},{default:l(()=>[h("查看更多 ")]),_:2},1032,["onClick"])])]),_:2},1024))),128))])])])])]),re]),n(q,{modelValue:m.value,"onUpdate:modelValue":s[3]||(s[3]=t=>m.value=t),title:"查看活动详情",width:"700",class:"max-h-[700px] overflow-y-auto","destroy-on-close":""},{footer:l(()=>[e("div",fe,[n($,{onClick:s[1]||(s[1]=t=>m.value=!1)},{default:l(()=>[h("Cancel")]),_:1}),n($,{type:"primary",onClick:s[2]||(s[2]=t=>m.value=!1)},{default:l(()=>[h(" Confirm ")]),_:1})])]),default:l(()=>[(i(!0),f(w,null,k(D.value.activities,t=>(i(),I(O,{onClick:p=>y(C).push({path:"/orderDetail",query:{activityId:t.id,userId:y(v).userInfo.id,date:d.value,title:t.title}})},{default:l(()=>[n(V,{class:"w-full line-clamp-2 text-ellipsis m-2"},{header:l(()=>[e("div",ie,[e("span",null,c(t.title),1),e("span",ce," ¥"+c(t.price===0?"免费":t.price),1)])]),default:l(()=>[e("div",de,c(t.desc),1),e("div",ue,[e("div",_e,[e("img",{src:t.images},null,8,pe)]),e("div",me,[n(o,{type:"primary"},{default:l(()=>[h("查看活动二维码")]),_:1})])])]),_:2},1024)]),_:2},1032,["onClick"]))),256))]),_:1},8,["modelValue"])],64)}}};export{be as default};