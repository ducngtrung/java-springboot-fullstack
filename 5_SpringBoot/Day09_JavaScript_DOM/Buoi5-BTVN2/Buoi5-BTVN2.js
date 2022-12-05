// Bài 1: Thay đổi phần tử đầu tiên và cuối cùng trong 1 danh sách
// Viết function thay đổi phần tử đầu và cuối trong mọi list có trên web page dưới dây. Phần tử đầu tiên trong list thay thành "first", phần tử cuối cùng thay thành "last"

  // <ul>
  //   <li>1</li>
  //   <li>2</li>
  //   <li>3</li>
  // </ul>
  // <ul>
  //   <li>a</li>
  //   <li>b</li>
  //   <li>c</li>
  // </ul>
  // <ul>
  //   <li>👻</li>
  //   <li>👽</li>
  //   <li>🦁</li>
  // </ul>

function question1() {
  let listArray = Array.from(document.getElementById("list").querySelectorAll("ul"));
  for (let list of listArray) {
    let newFirstItem = document.createElement("li");
    newFirstItem.innerHTML = "first";
    let newLastItem = document.createElement("li");
    newLastItem.innerHTML = "last";

    list.replaceChild(newFirstItem, list.firstElementChild);
    list.replaceChild(newLastItem, list.lastElementChild);
  }
}


// Bài 2: Đánh dấu từ trong văn bản
// Viết function nhận vào 1 argument là number, function có chức năng xác định tất cả các từ trong 1 đoạn văn có số ký tự dài hơn hoặc bằng tham số được truyền vào, sau đó đánh dấu những từ đó (tô đậm, hoặc bôi màu, …)

  // here are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.

function question2(number) {
  let paragraph = document.getElementById("paragraph").querySelector("p");
  let text = paragraph.innerText;
  let wordArray = text.replaceAll(".", "").replaceAll(",", "").split(" ");
  let uniqueWordArray = [...new Set(wordArray)];
  
  uniqueWordArray.forEach(word => {
    if (word.length >= number) {
      text = text.replace(word, `<b>${word}</b>`);
    }
  });
  paragraph.innerHTML = text;
}


// Bài 3: Thay đổi dấu
// Viết function thay thế tất cả các dấu ? bằng text why? và tất cả các dấu ! bằng text what? trong đoạn văn bản sau:

  // SMILEY: Hi, Lia. What seems to be the problem today?
  // LIA: I hope you can tell me! A chunk of my tooth broke off yesterday.
  // SMILEY: That’s not good. Did you bite something hard?
  // LIA: No, I didn’t . . . that’s the weird thing. It just kind of fell out.
  // SMILEY: Did it hurt when it broke?
  // LIA: Yes, it did, just a little; but it started to hurt like crazy this morning.
  // SMILEY: I think we’d better take a full set of X-rays . . . Okay, open wide. Let me take a look. Oh, boy. Yes, it looks like you’ve exposed the root on your left, molar.
  // LIA: rgscht rfghsh!! ghs gtfhhkj?
  // SMILEY: Sorry. I’ll be done in a minute. I’m afraid you’ll have to have a root canal. I can put in a temporary filling, but you’ll have to come back in two weeks for the procedure.
  // LIA: Do I have to have a root canal? My tooth doesn’t really hurt too much.
  // SMILEY: If we don’t take care of this quickly, it may become infected, and it will hurt a lot. I’ll tell Dina to set up an appointment, and I’ll see you back here in two weeks, on Tuesday, the 14th, at 3 p.m.
  // LIA: Will the procedure hurt?
  // SMILEY: I’ll give you medication so that you won’t feel any pain. Relax! It’s not so bad!

function question3() {
  let paragraph = document.getElementById("conversation").querySelector("p");
  let text = paragraph.innerHTML;
  text = text.replaceAll("?", "<b> why?</b>");
  text = text.replaceAll("!", "<b> what?</b>");
  paragraph.innerHTML = text;
}