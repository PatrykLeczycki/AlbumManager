$(document).ready(function() {
    $(".table").DataTable({
        "ordering": true,
        "searching": true,
        "paging": true,
        "columnDefs": [
            {
                "targets": [],
                "searchable": false,
                "orderable": false
            }
        ],
        "order": []
    });
});