$(document).ready(function() {
    $(".table").DataTable({
        "ordering": true,
        "searching": true,
        "paging": true,
        "columnDefs": [
            {
                "targets": [-1,-2, -3],
                "searchable": false,
                "orderable": false
            }
        ],
        "order": []
    });
});