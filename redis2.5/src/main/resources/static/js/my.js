function getIp() {
    var ip=window.document.location.href;
    return ip;
}
function get_2v_src(obj) {
    return 'http://2v.dedecms.com/index.php/welcome/generate_qrcode?message='+obj+'&size=10&line_cl=rgb%28255%2C255%2C255%29&bg_cl=rgb%280%2C0%2C0%29';
}
function getkeys() {
    $.ajax({
        type: "POST",
        url: "/getkeys",
        success: function(data){
            JSON.stringify(data);
        }
    });
}
function setSessions() {
    $.ajax({
        type: "POST",
        url: "/sessions",
        success: function(data){
            JSON.stringify(data);
        }
    });
}
function flush() {
    $.ajax({
        type: "POST",
        url: "/flush",
        success: function(data){
            JSON.stringify(data);
        }
    });
}

// function get_2v_src(id,text,width,height,background,foreground,src) {
//     jQuery(id).qrcode({
//         render    : "canvas",
//         text    : text,
//         width : width,               //二维码的宽度
//         height : height,              //二维码的高度
//         background :background,       //二维码的后景色
//         foreground :foreground,        //二维码的前景色
//         src: src             //二维码中间的图片
//     });
// }

// function hot() {
//     $.ajax({
//         type: "POST",
//         url: "/getDeviceInfo",
//         dataType: "json",
//         data: {"deviceID":1},
//         success: function(data){
//             JSON.stringify(data);
//             var table = $("#projectImg");
//
//             var table2=$("#deviceName");
//             var table3=$("#devicePrice");
//             var table4=$("#deviceState");
//             var table5=$("#palaceName");
//
//             var value = data;
//
//             var lia='<img src="' + value.deviceImg + '" width="50%"/>';
//
//             table.append(lia);
//             var lib=value.deviceName;
//             table2.append(lib);
//             var lic=(parseFloat(value.devicePrice)/100).toFixed(2);
//             table3.append(lic);
//
//             var lih=value.palaceName;
//             table5.append(lih);
//
//         }
//     });$.ajax({
//         type: "POST",
//         url: "/getDeviceInfo",
//         dataType: "json",
//         data: {"deviceID":1},
//         success: function(data){
//             JSON.stringify(data);
//             var table = $("#projectImg");
//
//             var table2=$("#deviceName");
//             var table3=$("#devicePrice");
//             var table4=$("#deviceState");
//             var table5=$("#palaceName");
//
//             var value = data;
//
//             var lia='<img src="' + value.deviceImg + '" width="50%"/>';
//
//             table.append(lia);
//             var lib=value.deviceName;
//             table2.append(lib);
//             var lic=(parseFloat(value.devicePrice)/100).toFixed(2);
//             table3.append(lic);
//
//             var lih=value.palaceName;
//             table5.append(lih);
//
//         }
//     });
// }
