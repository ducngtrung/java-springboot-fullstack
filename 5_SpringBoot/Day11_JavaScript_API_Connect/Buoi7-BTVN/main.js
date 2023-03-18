// Xây dựng từ điển online đơn giản:
    // Tạo 1 trang html có input form + search button
    // Sử dụng api https://dictionaryapi.dev/ để lấy thông tin từ được nhập vào và tra nghĩa.
    // Kết quả trả ra từ api sẽ bao gồm giải nghĩa của từ + loại từ (danh từ, tính từ, …) + link âm thanh phát âm của từ đó
    // Tham khảo cách dùng thẻ <audio> trong html tại link sau (https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_audio)


const searchInput = document.getElementById("search-field");
const searchBtn = document.getElementById('submit-button');
const partOfSpeech = document.getElementById('part-of-speech');
const definitions = document.getElementById('definitions');
const wordAudio = document.getElementById('word-audio');
var result;


// Hàm gọi API để lấy danh sách meanings
function getMeanings() {
    // Lấy ra word đã được nhập ở ô tìm kiếm
    let wordToSearch = document.getElementById('search-field').value;
    let response = axios.get(`https://api.dictionaryapi.dev/api/v2/entries/en/${wordToSearch}`);
    response
        // Sau khi có data thì gọi hàm renderMeanings
        .then(function(res) {
            result = res.data[0]; // meanings là một array có thể chứa nhiều định nghĩa của cùng 1 từ
            console.log(result.meanings);
            renderMeanings(result.meanings);
            renderWordAudio(result);
        })
        .catch(error => {
            console.log(error);
        })
}

// Hàm duyệt từng phần tử trong mảng meanings -> dùng DOM để đưa partOfSpeech vào HTML
function renderMeanings(meaningList) {
    partOfSpeech.textContent = "";
    definitions.textContent = "";
    meaningList.forEach(meaning => {
        let newPartOfSpeech = document.createElement("p");
        newPartOfSpeech.innerHTML = meaning.partOfSpeech;
        newPartOfSpeech.className = "part-of-speech-detail";
        newPartOfSpeech.style.cursor = "pointer";
        partOfSpeech.appendChild(newPartOfSpeech);
    });
}

// Hàm lấy URL của audio -> dùng DOM đưa vào HTML
function renderWordAudio(result) {
    wordAudio.innerHTML = "";
    let audioPlayer =  `<audio src="${result.phonetics[0].audio}?noCache=${Math.floor(Math.random()*1000000)}" type="audio/mpeg" controls></audio>`;
    wordAudio.innerHTML = audioPlayer;
}

// Hàm duyệt từng phần tử trong mảng meanings -> dùng DOM để đưa definition tương ứng với partOfSpeech vào HTML
function renderDefinitions(partOfSpeech, meaningList) {
    definitions.textContent = "";
    meaningList.forEach(meaning => {
        if (meaning.partOfSpeech === partOfSpeech) {
            meaning.definitions.forEach((definitionItem, index) => {
                let newDefinition = document.createElement("p");
                newDefinition.innerHTML = `(${index + 1}) ${definitionItem.definition}`;
                newDefinition.className = "definition-detail";
                definitions.appendChild(newDefinition);
            });
            return;
        } 
    });
}


// Lắng nghe sự kiện khi nhấn phím Enter sau khi nhập từ khóa
searchInput.addEventListener("keypress", function(event) {
  if (event.key === "Enter") {
    // Cancel the default action, if needed
    event.preventDefault();
    // Trigger the button element with a click
    searchBtn.click();
  }
});

// Lắng nghe sự kiện khi click vào nút "Search" để lấy word definition
searchBtn.addEventListener("click", function () {
    partOfSpeech.textContent = "";
    definitions.textContent = "";
    wordAudio.innerHTML = "";
    document.querySelector(".result").style.visibility = "visible";
    getMeanings();
});

// Lắng nghe sự kiện khi click vào part-of-speech-detail để hiển thị definition
partOfSpeech.addEventListener("click", function(event) {
    if (event.target && event.target.matches("p.part-of-speech-detail")) {
        let activePartOfSpeech = event.target.innerText;
        renderDefinitions(activePartOfSpeech, result.meanings);
    }
});