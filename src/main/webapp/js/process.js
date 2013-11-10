$(function() {
     $( "#dialog-message" ).dialog({
        modal: true,
        autoOpen: false,
        buttons: {
            "Ok": function() {
                $( this ).dialog( "close" );
            },
            "Edit user": function() {
                window.location.href = $('#edit_url').val();
            }
        }
     });
});

$(document).ready(function () {

});

$('.infoButton').click(function(){
    $.ajax({
        type: "GET",
        url: "infoUser.html",
        data: { id: this.id.substring(9)}
    })
    .done(function( msg ) {
        $('#dialog-message').html(msg);
        $('#dialog-message').dialog("open");
    });
});
$('.delButton').click(function(){if(confirm('User will be deleted. Are you sure?')){ window.location.href = "deleteUser.html?id="+this.id.substring(8);}});