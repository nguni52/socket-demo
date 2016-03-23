/**
 * Created by nguni52 on 16/03/23.
 */
var socket = new SockJS('/register');
stompClient = Stomp.over(socket);
stompClient.connect({}, function(frame) {//'testuser', 'pwd123xyz'
    stompClient.subscribe('/app/subscribe', function(message){
        console.log(message);
    });
    stompClient.send('/app/send', {}, "testing ...");

    stompClient.subscribe('/user/queue/auth')
});