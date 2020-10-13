$(function()
{
    $("td.book-title").click(function()
    {
        let seq = $(this).data("seq");
        document.location.href = `${rootPath}/books/detail/${seq}` // Path Varriable 방식
    })
})