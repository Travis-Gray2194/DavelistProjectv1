window.onload = function(){
    var form = document.getElementById('submitFormSelect');

    function submitForm(){
        if(confirm('Are you sure you want to save this Library Information?')){
            form.submit();
        } else {
            return false;
        }
    }

    if(form.addEventListener) {
        form.addEventListener('change',submitForm,false);
    } else if(form.attachEvent) {
        form.attachEvent('onchange',submitForm);
    }
}