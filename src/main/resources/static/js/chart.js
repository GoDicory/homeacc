
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
                borderWidth: 1
            }]
        }
    });
});