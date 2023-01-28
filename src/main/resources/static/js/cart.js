<script>
    function minusQuantity() {
        var quantity = document.getElementById("product-quantity").value;
        if(quantity > 0) {
            document.getElementById("product-quantity").value = --quantity;
        }
    }

    function addQuantity() {
        var quantity = document.getElementById("product-quantity").value;
        document.getElementById("product-quantity").value = ++quantity;
}
  // Get all rows in the table
  var rows = document.querySelectorAll("table tbody tr");

  // Loop through each row
  rows.forEach(function(row) {
    // Get the quantity and value cells
    var quantityCell = row.querySelector("td:nth-child(2)");
    var valueCell = row.querySelector("td:nth-child(3)");
    var totalValueCell = row.querySelector("td:nth-child(4) span");
    // Get the quantity and value
    var quantity = parseInt(quantityCell.textContent);
    var value = parseFloat(valueCell.textContent);

    // Calculate the total value and set it as the text content of the total value cell
    totalValueCell.textContent = (quantity * value).toFixed(2);
  });
</script>