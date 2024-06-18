
function addNewSmartPhone(){
    //lấy dữ liệu từ form html
    let producer = $("#producer").val();
    let model = $("#model").val();
    let price = $("#price").val();
    let newSmartphone = {
        producer: producer,
        model: model,
        price: price
    };
    // gọi phương thức ajax
    $.ajax({
        // headers: {
        //     'accept': 'application/json',
        //     'content-Type': 'application/json'
        // },
        type: "POST",
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(newSmartphone),
        //tên API
        url: "http://localhost:8080/api/smartphones",
        //xử lý khi thành công
        success: console.log("Tạo mới thành công")
    });
    //chặn sự kiện mặc định của thẻ
    event.preventDefault();
}

function successHandler(){
    $.ajax({
        type: "GET",
        //tên API
        url: "http://localhost:8080/api/smartphones",
        //xử lý khi thành công
        success: function (data){
            console.log(data)
            // hiển thị danh sách ở đây
            let content = ' <table id="display-list" border="1"><tr>\n' +
                ' <th>Producer</td>\n' +
                ' <th>Model</td>\n' +
                ' <th>Price</td>\n' +
                ' <th>Delete</td>\n' +
                ' <th>Update</td>\n' +
                ' </tr>';
            for (let i = 0; i < data.length; i++) {
                content += getSmartphone(data[i]);
            }
            content += "</table>"
            document.getElementById('smartphoneList').innerHTML = content;
            document.getElementById('smartphoneList').style.display = "block";
            document.getElementById('add-smartphone-form').style.display = "none";
            document.getElementById('display-create-btn').style.display = "block";
            document.getElementById('display-btn').style.display = "none";
            document.getElementById('title').style.display = "block";
        }
    })
}

function displayFormCreate() {
    document.getElementById('smartphoneList').style.display = "none";
    document.getElementById('add-smartphone-form').style.display = "block";
    document.getElementById('display-create-btn').style.display = "none";
    document.getElementById('display-btn').style.display = "inline";
    document.getElementById('title').style.display = "none";
    // document.getElementById('save').style.display = "none";
}

function getSmartphone(smartphone) {
    return`<tr>
<td >${smartphone.producer}</td>
<td >${smartphone.model}</td>
<td >${smartphone.price}</td>` +
`<td class="btn"><button class="deleteSmartphone" onclick="deleteSmartphone(${smartphone.id})">Delete</button></td>
<td class="btn"><button class="updateSmartphone" onclick="showUpdateForm(${smartphone.id})">Update</button></td>
</tr>`;
}
function deleteSmartphone(id) {
    $.ajax({
        type: "DELETE",
        //tên API
        url: `http://localhost:8080/api/smartphones/${id}`,
        //xử lý khi thành công
        success: successHandler
    });
}
function showUpdateForm(id) {
    $.ajax({
        type: "GET",
        //tên API
        url: `http://localhost:8080/api/smartphones/${id}`,
        success: function (data){
            displayFormCreate()
            document.getElementById('save').style.display = "block";
            document.getElementById('display-btn').style.display = "inline";
            $("#id").val(`${data.id}`);
            $("#producer").val(`${data.producer}`);
            $("#model").val(`${data.model}`);
            $("#price").val(`${data.price}`);
            $("h1").text("Form Update")
            $("#add").hide()
            $("#save").html(`<input type=\"submit\" value=\"Save\" onclick=\"updateSmartPhone(${data.id})\">`);
            // $("#tr").html("<td><label >ID:</label></td>\n" + `<td><input type="text" id='id' value="${data.id}" readonly></td>`);

        }
    });
}
function updateSmartPhone(id){
    //lấy dữ liệu từ form html
    let producer = $("#producer").val();
    let model = $("#model").val();
    let price = $("#price").val();
    // gọi phương thức ajax
    $.ajax({
        type: "PUT",
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify({
            id: id,
            producer: producer,
            model: model,
            price: price
        }),
        //tên API
        url: `http://localhost:8080/api/smartphones/${id}`,
        //xử lý khi thành công
        success: function () {
            $("#producer").val("");
            $("#model").val("");
            $("#price").val("");
            console.log("Cập nhật thành công");
        }
    });
    //chặn sự kiện mặc định của thẻ
    event.preventDefault();
}