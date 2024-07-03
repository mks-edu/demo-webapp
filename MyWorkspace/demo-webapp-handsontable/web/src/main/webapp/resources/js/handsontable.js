var hotProduct;
/**
 * Processing events of search OKR by emails.
 */
$(document).ready(function() {
    loadTableData();
});

/**
 * Load column width, header, initTable()
 */
function loadTableData() {
        
    $.ajax({
        url : _ctx + 'handsontable/loaddata',
        type : 'GET',
        dataType : 'json',
        contentType : 'application/json',
        success : function(res) {
            console.log("res=" + JSON.stringify(res));
    
            if (res) {
                initTable(res.colHeaders, res.colWidths, res.data);
            } else {
                console.log("Error: no result.");
            }              
        },
        error : function (e) {
            console.log("Error: " + e);
        }
    });
}

function initTable(colHeaders, colWidths, data) {
  var container = document.getElementById('tblProduct');
  
  hotProduct = new Handsontable(container, {
        data: data,
        colHeaders: colHeaders,
        colWidths: colWidths,
        // height: 800,
        rowHeaders: true,
        minRows: 10,
        currentRowClassName: 'currentRow',
        currentColClassName: 'currentCol',
        manualColumnResize: true,
        manualRowResize: true,
        minSpareRows : 1,
        contextMenu: true,
        licenseKey: 'non-commercial-and-evaluation'
  });
}

function updateTable(colHeaders, colWidths, data) {
    hotProduct.loadData(data);
}

/**
 * Processing events of question table.
 */
$(document).ready(function() {

    $('#formInput').submit(function(e) {
        e.preventDefault();
        
        var colHeaders = hotProduct.getColHeader();
        var tableData = hotProduct.getData();
        
        // Build array of column width
        var colWidths=[]
        for (let i = 0; i < colHeaders.length; i++) {
            let w = hotProduct.getColWidth(i);
            colWidths.push(w);
        }
        
        console.log("colHeaders=" + colHeaders);
        console.log("colWidths=" + colWidths);
    
        var formDataJson = JSON.stringify({"colWidths": colWidths, "colHeaders": colHeaders, "data": tableData});
        
        $.ajax({
          url : _ctx + 'handsontable/save',
          type : 'POST',
          data : formDataJson,
          dataType: "json",
          contentType: 'application/json',
          success : function(res) {
              // result = JSON.parse(result);
              console.log("Result res.colHeaders:" + res.colHeaders);
              updateTable(res.colHeaders, res.colWidths, res.data);
          },
          error : function() {
              console.log("Error!");
          }
        });
    });
});
