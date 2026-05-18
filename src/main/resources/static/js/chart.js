
document.addEventListener('DOMContentLoaded', function() {
    const ctx = document.getElementById('transactionsChart').getContext('2d');

    var transaction_x = transactions.map(t => t["summa"]);
    var transaction_y = transactions.map(t => t["categories"]);

    new Chart(ctx, {
        type: 'pie',
        data: {
            labels: transaction_y,
            datasets: [{
                data: transaction_x,
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)'
                ],
                borderColor: [
                    'rgb(255, 99, 132)',
                    'rgb(54, 162, 235)',
                    'rgb(255, 206, 86)',
                    'rgb(75, 192, 192)'
                ],
                borderWidth: 1
            }]
        }
    });
});