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
                tblProductData = res;
                tblProductColHeaders = res.colHeaders;
                tblProductColWidths = res.colWidths;
                okrData = res.data;
                initTable();
            }                
        },
        error : function (e) {
            console.log("Error: " + e);
        }
    });
}

function initTable() {
  var container = document.getElementById('tblProduct');
  
  hotProduct = new Handsontable(container, {
        data: tblProductData.data,
        colHeaders: tblProductData.colHeaders,
        colWidths: tblProductData.colWidths,
        height: 800,
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

/**
 * Processing events of question table.
 */
$(document).ready(function() {

    $('#formInput').submit(function(e) {
      e.preventDefault();
    
      var tableData = hotProduct.getData();
    
      $.ajax({
          url : _ctx + 'handsontable/save',
          type : 'POST',
          data : JSON.stringify(tableData),
          dataType: "json",
          contentType: 'application/json',
          success : function(result) {
              result = JSON.parse(result);
              console.log("Result:" + result.status);
          },
          error : function() {
              console.log("Error!");
          }
      });
    });
});
