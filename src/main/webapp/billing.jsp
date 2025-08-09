<%--
  Created by IntelliJ IDEA.
  User: kaviruMendis
  Date: 8/9/2025
  Time: 5:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: kaviruMendis
  Date: 8/9/2025
  Time: 5:46 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.pahanaeduonlinebillingsys.customer.model.CustomerRegister" %>
<%@ page import="com.example.pahanaeduonlinebillingsys.items.model.ItemAdd" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.LinkedHashMap" %>

<html>
<head>
    <title>Billing</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">

    <h3>Search Customer by Account No</h3>
    <form action="billing" method="get" class="mb-4">
        <input type="text" name="accno" placeholder="Enter Account No" class="form-control" required>
        <button type="submit" class="btn btn-primary mt-2">Search</button>
    </form>

    <%
        String message = (String) request.getAttribute("message");
        CustomerRegister customer = (CustomerRegister) request.getAttribute("customer");
        Map<String, ItemAdd> itemDetails = (Map<String, ItemAdd>) request.getAttribute("itemDetails");
        Map<String, Integer> itemMap = (Map<String, Integer>) request.getAttribute("itemMap");
        String billId = (String) request.getAttribute("billId");
    %>

    <% if (message != null) { %>
    <div class="alert alert-info"><%= message %></div>
    <% } %>

    <% if (customer != null) { %>

    <div class="card p-3 mb-4">
        <h5>Customer Details</h5>
        <p><b>Account No:</b> <%= customer.getAccNo() %></p>
        <p><b>Name:</b> <%= customer.getFirstName() + " " + customer.getLastName() %></p>
        <p><b>Address:</b> <%= customer.getAddress() %></p>
        <p><b>Mobile:</b> <%= customer.getMobileNo() %></p>
    </div>

    <h5>Enter Items to Bill</h5>
    <form action="billing" method="post" id="billingForm">

        <input type="hidden" name="accno" value="<%= customer.getAccNo() %>">
        <input type="hidden" id="billId" name="billId" value="<%= (billId != null) ? billId : "" %>">

        <div id="items-container">
            <%
                if (itemMap != null && itemDetails != null && !itemMap.isEmpty()) {
                    for (Map.Entry<String, Integer> entry : itemMap.entrySet()) {
                        String itemNo = entry.getKey();
                        int qty = entry.getValue();
                        ItemAdd item = itemDetails.get(itemNo);
                        if (item != null) {
            %>
            <div class="row mb-3 item-row" data-itemno="<%= itemNo %>">
                <div class="col">
                    <input type="text" name="itemno" class="form-control" value="<%= itemNo %>" readonly>
                </div>
                <div class="col">
                    <input type="number" name="quantity" class="form-control qty-input" min="1" value="<%= qty %>" required>
                </div>
                <div class="col">
                    <input type="text" class="form-control" value="<%= item.getItemname() %>" readonly>
                </div>
                <div class="col">
                    <input type="text" class="form-control unit-price" value="<%= item.getUnitprice() %>" readonly>
                </div>
                <div class="col">
                    <input type="text" class="form-control total-price" value="<%= (Double.parseDouble(item.getUnitprice()) * qty) %>" readonly>
                </div>
                <div class="col-auto">
                    <button type="button" class="btn btn-danger btn-remove">Remove</button>
                </div>
            </div>
            <%
                    }
                }
            } else {
            %>
            <div class="row mb-3 item-row" data-itemno="">
                <div class="col">
                    <input type="text" name="itemno" placeholder="Item No" class="form-control" required>
                </div>
                <div class="col">
                    <input type="number" name="quantity" placeholder="Quantity" class="form-control qty-input" min="1" required>
                </div>
                <div class="col">
                    <input type="text" class="form-control" placeholder="Item Name" readonly>
                </div>
                <div class="col">
                    <input type="text" class="form-control unit-price" placeholder="Unit Price" readonly>
                </div>
                <div class="col">
                    <input type="text" class="form-control total-price" placeholder="Total Price" readonly>
                </div>
                <div class="col-auto">
                    <button type="button" class="btn btn-danger btn-remove" disabled>Remove</button>
                </div>
            </div>
            <%
                }
            %>
        </div>

        <button type="button" class="btn btn-secondary mb-3" onclick="addItem()">Add Another Item</button>
        <br>

        <h5>Total Amount: Rs. <span id="totalAmount">0.00</span></h5>

        <button type="submit" class="btn btn-success" id="calculateBtn">Calculate & Save Bill</button>
        <button type="button" class="btn btn-primary" id="payBtn">Pay Bill</button>
        <button type="button" class="btn btn-info" onclick="printReceipt()">Print Bill</button>
    </form>

    <!-- Receipt Section - hidden by default -->
    <div id="receipt" style="display:none; margin-top:30px; border:1px solid #000; padding:15px; background:#fff;">
        <h2 style="text-align:center;">PahanaEduOnlinePayment</h2>
        <p><b>Bill ID:</b> <span id="receiptBillId"></span></p>
        <p><b>Account No:</b> <span id="receiptAccNo"></span></p>
        <p><b>Name:</b> <span id="receiptName"></span></p>
        <p><b>Mobile No:</b> <span id="receiptMobile"></span></p>

        <table class="table table-bordered mt-3">
            <thead>
            <tr>
                <th>Item No</th>
                <th>Name</th>
                <th>Quantity</th>
                <th>Total Price (Rs.)</th>
            </tr>
            </thead>
            <tbody id="receiptItems">
            <!-- Items will be added here dynamically -->
            </tbody>
        </table>

        <h4>Total Amount: Rs. <span id="receiptTotalAmount"></span></h4>
    </div>

    <% } %>

</div>

<script>
    // Add new item row
    function addItem() {
        const container = document.getElementById('items-container');
        const div = document.createElement('div');
        div.className = 'row mb-3 item-row';
        div.innerHTML = `
            <div class="col">
                <input type="text" name="itemno" placeholder="Item No" class="form-control" required>
            </div>
            <div class="col">
                <input type="number" name="quantity" placeholder="Quantity" class="form-control qty-input" min="1" required>
            </div>
            <div class="col">
                <input type="text" class="form-control" placeholder="Item Name" readonly>
            </div>
            <div class="col">
                <input type="text" class="form-control unit-price" placeholder="Unit Price" readonly>
            </div>
            <div class="col">
                <input type="text" class="form-control total-price" placeholder="Total Price" readonly>
            </div>
            <div class="col-auto">
                <button type="button" class="btn btn-danger btn-remove">Remove</button>
            </div>
        `;
        container.appendChild(div);
        attachEvents(div);
    }

    // Update totals
    function updateTotals() {
        let totalAmount = 0;
        document.querySelectorAll('.item-row').forEach(row => {
            const qtyInput = row.querySelector('.qty-input');
            const unitPriceInput = row.querySelector('.unit-price');
            const totalPriceInput = row.querySelector('.total-price');
            const qty = parseInt(qtyInput.value) || 0;
            const unitPrice = parseFloat(unitPriceInput.value) || 0;
            const total = qty * unitPrice;
            totalPriceInput.value = total.toFixed(2);
            totalAmount += total;
        });
        document.getElementById('totalAmount').textContent = totalAmount.toFixed(2);
    }

    // Attach events to row elements
    function attachEvents(row) {
        // Remove button
        row.querySelector('.btn-remove').addEventListener('click', () => {
            row.remove();
            updateTotals();
        });

        // Quantity change updates totals
        row.querySelector('.qty-input').addEventListener('input', updateTotals);

        // Item No input: for demo, we skip backend fetch, just clear price fields
        row.querySelector('input[name="itemno"]').addEventListener('change', function() {
            // Clear item name, unit price, total price for now
            const nameInput = row.querySelector('input[readonly].form-control:not([name])');
            const unitPriceInput = row.querySelector('.unit-price');
            const totalPriceInput = row.querySelector('.total-price');
            nameInput.value = "";
            unitPriceInput.value = "";
            totalPriceInput.value = "";
            updateTotals();
            alert('Please implement backend item lookup to auto-fill name and price.');
        });
    }

    // Attach events to existing rows on page load
    document.querySelectorAll('.item-row').forEach(attachEvents);

    // Initial totals update
    updateTotals();

    // Pay Bill button logic
    document.getElementById('payBtn').addEventListener('click', function () {
        // Submit form via POST but add a hidden field "action=pay"
        let form = document.getElementById('billingForm');
        // Create or update hidden input for action
        let actionInput = document.getElementById('actionInput');
        if (!actionInput) {
            actionInput = document.createElement('input');
            actionInput.type = 'hidden';
            actionInput.id = 'actionInput';
            actionInput.name = 'action';
            form.appendChild(actionInput);
        }
        actionInput.value = 'pay';
        form.submit();
    });

    // Print receipt function
    function printReceipt() {
        // Check if billId exists
        let billId = document.getElementById('billId').value;
        if (!billId) {
            alert("Please calculate and pay the bill first.");
            return;
        }

        const accNo = document.querySelector('input[name="accno"]').value;
        const name = '<%= customer != null ? customer.getFirstName().replace("'", "\\'") + " " + customer.getLastName().replace("'", "\\'") : "" %>';
        const mobile = '<%= customer != null ? customer.getMobileNo().replace("'", "\\'") : "" %>';

        // Fill receipt header info
        document.getElementById('receiptBillId').textContent = billId;
        document.getElementById('receiptAccNo').textContent = accNo;
        document.getElementById('receiptName').textContent = name;
        document.getElementById('receiptMobile').textContent = mobile;

        // Fill receipt items
        const receiptItemsBody = document.getElementById('receiptItems');
        receiptItemsBody.innerHTML = '';

        let totalAmount = 0;

        document.querySelectorAll('.item-row').forEach(row => {
            const itemNo = row.querySelector('input[name="itemno"]').value;
            const itemName = row.querySelector('input[readonly].form-control:not([name])').value;
            const qty = row.querySelector('input[name="quantity"]').value;
            const totalPrice = row.querySelector('.total-price').value;

            totalAmount += parseFloat(totalPrice) || 0;

            const tr = document.createElement('tr');
            tr.innerHTML =
                "<td>" + itemNo + "</td>" +
                "<td>" + itemName + "</td>" +
                "<td>" + qty + "</td>" +
                "<td>" + parseFloat(totalPrice).toFixed(2) + "</td>";

            receiptItemsBody.appendChild(tr);
        });

        document.getElementById('receiptTotalAmount').textContent = totalAmount.toFixed(2);

        // Hide form, show receipt
        document.getElementById('billingForm').style.display = 'none';
        document.getElementById('receipt').style.display = 'block';

        // Print
        window.print();

        // After print, revert back
        document.getElementById('billingForm').style.display = 'block';
        document.getElementById('receipt').style.display = 'none';
    }
</script>

</body>
</html>
