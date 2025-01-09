var dataSet;


$(document).ready(function () {
    $.ajax({
        url : _ctx + 'datatable/loaddata',
        type : 'GET',
        dataType : 'json',
        contentType : 'application/json',
        success : function(res) {
            // Debug
            console.log("res=" + JSON.stringify(res));
            if (res) {
                dataSet = res.data;
                initTable();
            }                
        },
        error : function (e) {
            console.log("Error: " + e);
        }
    });
    
});

function initTable() {
    $("#tblDatatable").DataTable({
        data: dataSet,
        dom: 'Bfrtip',
        buttons: [
            'copyHtml5',
            'excelHtml5',
            'csvHtml5',
            'pdfHtml5'
        ]
    });
}

$(document).ready(function () {
    const options = ['Black', 'Blue', 'Green', 'Red', 'White', 'Yellow']; // Existing options for the dropdown
    const editableColumns = [2]; // Specify the columns where editing is allowed (zero-based index)

    // Delegate click event to table cells
    $('#tblDatatable').on('click', 'tbody td', function () {
        const cell = $(this); // The clicked cell
        const columnIndex = cell.index(); // Get the index of the clicked cell's column

        // Check if the column is editable
        if (!editableColumns.includes(columnIndex)) {
            return; // Do nothing if the column is not editable
        }

        const originalValue = cell.text().trim(); // Get the cell's current value

        // Prevent creating a new select box if one is already being edited
        if (cell.find('select').length > 0 || cell.find('input').length > 0) {
            return;
        }

        // Create a select box with existing options
        const selectHTML = `<select id="edit-select" class="form-control">
                              ${options.map(opt => `<option value="${opt}" ${opt === originalValue ? 'selected' : ''}>${opt}</option>`).join('')}
                              <option value="new">[New Value]</option>
                            </select>`;

        // Create an input field (hidden initially)
        const inputHTML = `<input type="text" id="edit-input" class="form-control" style="display:none;" placeholder="Enter new value">`;

        // Replace cell content with the editor
        cell.html(selectHTML + inputHTML);

        // Focus on the select box
        const select = $('#edit-select'); // Define the select element
        const input = $('#edit-input'); // Define the input element
        select.focus();

        // Stop propagation of the click event for the select box
        select.on('click', function (e) {
            e.stopPropagation();
        });

        // Handle select box change
        select.on('change', function () {
            if ($(this).val() === 'new') {
                // Show input field for new value
                input.show().focus();
            } else {
                // Hide input field and update cell with the selected value
                input.hide();
                const newValue = $(this).val();
                cell.html(newValue);
            }
        });

        // Handle input field blur (for new value)
        input.on('blur', function () {
            const newValue = $(this).val();
            if (newValue.trim()) {
                // Update cell with the new value
                cell.html(newValue);
            } else {
                // Revert to original value if no input
                cell.html(originalValue);
            }
        });

        // Handle input field keypress (for Enter key)
        input.on('keypress', function (e) {
            if (e.which === 13) { // Enter key
                $(this).blur(); // Trigger blur to save the new value
            }
        });
    });
});
