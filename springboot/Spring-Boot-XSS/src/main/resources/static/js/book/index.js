$(function() {
    initBooks();
    bindEvent();

    function bindEvent() {
        $("#addBtn").click(function() {
            window.open('/books/addPage', "_self");
        });
    }

    function initBooks() {
        $.ajax({
            url: '/books/all',
            type: 'GET',
            dataType: 'JSON',
            success: function(json) {
                $("#dataList").empty();
                if (json.length <= 0) {
                    $("#dataList").append($('<tr><td colspan="6">暂无数据</td></tr>'));
                    return;
                }
                json.forEach(function(item, index) {
                    var _tr = '<tr>' +
                        '<td>' + (index + 1) + '</td>' +
                        '<td>' + item.name + '</td>' +
                        '<td>' + item.author + '</td>' +
                        '<td>' + item.type + '</td>' +
                        '<td>' + item.publicationDate + '</td>' +
                        '<td>' + item.description + '</td>' +
                        '</tr>';
                    $("#dataList").append($(_tr));
                });
            }
        })
    }
});