
document.addEventListener('DOMContentLoaded', function() {
    const ctx = document.getElementById('transactionsChart').getContext('2d');

    var summaCategories = {};

    for (var i = 0; i < transactions.length; i++){
        var categories = transactions[i]["categories"];
        var summa = transactions[i]["summa"];

        if(summaCategories[categories]){
            summaCategories[categories] = summaCategories[categories] + summa;
        } else {
            summaCategories[categories] = summa;
        }
    }

    var categoriesAll = Object.keys(summaCategories);
    var summaAll = Object.values(summaCategories)

    new Chart(ctx, {
        type: 'pie',
        data: {
            labels: categoriesAll,
            datasets: [{
                data: summaAll,
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