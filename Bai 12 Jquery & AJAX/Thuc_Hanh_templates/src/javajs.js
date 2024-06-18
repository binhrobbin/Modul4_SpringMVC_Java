// function showUpdateForm(id){
//     console.log("vào consolog")
//     $("h1").text("Form Update")
//     $.ajax({
//         type: "Get",
//         url:`http://localhost:8080/api/student/v1/${id}`,
//         success: function (data){
//             $("#id").val(`${data.id}`)
//             $("#name").val(`${data.name}`)
//             $("#0").radio()
//             $("#add").hide()
//             $("#save").html(`<input type="submit" value="Save" id="save" onclick="updateSmartPhone(${data.id})">`)
//         }
//     })
// }
// function updateSmartPhone(id){
// }