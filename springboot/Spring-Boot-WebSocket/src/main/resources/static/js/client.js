    const ws = {
        start() {
            ws.url = '/connect';
            ws.ws = new SockJS(ws.url);
            ws.ws.onopen = function () {
                console.log('和服务端连接成功！');
            };
            ws.ws.onmessage = function (event) {
                console.log('服务端：' + event.data);
            };
            ws.ws.onclose = function () {
                console.log('和服务端断开连接！')
            }
        },
        send(msg) {
            if (ws.ws) {
                ws.ws.send(msg);
                console.log('客户端：' + msg);
            } else {
                console.log('没有建立链接!');
            }
        }
    }
    ws.start();