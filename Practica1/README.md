# chat-example

This is the source code for a very simple chat example used for
the [Getting Started](http://socket.io/get-started/chat/) guide
of the Socket.IO website.

Please refer to it to learn how to run this application.

You can also spin up a free Heroku dyno to test it out:

[![Deploy](https://www.herokucdn.com/deploy/button.png)](https://heroku.com/deploy?template=https://github.com/socketio/chat-example)

### Demo

https://chat-example-1-copy.mgh99.repl.co/

### Updates

* Button for close the socket of the chat.

```html
<form>
   <button id = "close">Close</button>
</form>

<script>
  var close = document.getElementById('close');
      
        close.addEventListener("click", (e) => {
          e.preventDefault();
          var item = document.createElement('li');
          item.textContext = "Te has desconectado";
          messages.appendChild(item);
          window.scrollTo(0, document.body.scrollHeight);
          socket.disconnected();
        });
</script>

```

* You can send emojis on the chat

```
<style>
   #selectEmoji {
          border: 4px solid #333;
          border-radius: 5px;
          width: 10%;
   }
</style>

<form id="form" action="">
      <button id = "close">Close</button>
        <input id="input" autocomplete="off" /><button>Send</button>
      <select id = "selectEmoji" onchange = "addEmoji(value)" size = "0"</select>
</form>

<script>
  var selectEmoji = document.getElementById("selectEmoji");

  const addEmoji = (value) => {
     input.value += String.fromCodePoint(value);
  }

  let emojiValue = 128517; //valor de los emojis
  while(emojiValue <= 129080) {
     const newOption = document.createElement("option");
     newOption.textContent = String.fromCodePoint(emojiValue);
     newOption.value = emojiValue;
     selectEmoji.appendChild(newOption);
     emojiValue++;
   }
</script>

```
-----------------------------------------------------------------------
### Visualization 

![](https://github.com/mgh99/Sistemas_Distribuidos/blob/main/Practica1/img/img-chat-socket.png)





