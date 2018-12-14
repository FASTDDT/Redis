function getIp() {
    $.ajax({
        type: "POST",
        url: "/Nomal/getIp",
        success: function(data){
            JSON.stringify(data);
            return data.data;
        }
    });
}
function get_2v_src(ip,port) {
    return 'http://2v.dedecms.com/index.php/welcome/generate_qrcode?message=http://'+ip+':'+port+'&size=10&line_cl=rgb%28255%2C255%2C255%29&bg_cl=rgb%280%2C0%2C0%29';
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
function show2v(){
    $.post("/Nomal/getIp",function(data){
        alert(data);
        var ip=data.data;
        var src=get_2v_src(ip,8888);
        var img='<img src="'+src+'">';
        $("#img").append(img);
    });
}
function setSessionId() {
    var s=$("#sessionId").html();
    localStorage.setItem("sessionId",s);
}


