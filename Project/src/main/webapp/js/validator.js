function Validator(formCV) {

    function getParent(element, selector){
        while (element.parentElement){
            if(element.parentElement.matches(selector)){
                return element.parentElement;
            }
            element = element.parentElement;
        }
    }

    var formRules = {};

    var validatorRules = {
        required: function (value) {
            return value ? undefined : 'Vui lòng nhập trường này!';
        },
        email: function (value) {
            var regex =/^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$/
            return regex.test(value) ? undefined : 'Vui lòng nhập đúng định dạng số điện thoại!';
        },
        sdt: function (value) {
            var regex = /^[a-z][a-z0-9_\.]{5,32}@[a-z0-9]{2,}(\.[a-z0-9]{2,4}){1,2}$/;
            return regex.test(value) ? undefined : 'Vui lòng nhập đúng định dạng email!';
        },
        min: function (min) {
            return function (value){
                return value.length >= min ? undefined : 'Vui lòng nhập nhiều hơn hơn ' + min + ' kí tự!';
            }
        },
        max: function (max) {
            return function (value){
                return value.length <= max ? undefined : 'Vui lòng nhập không quá ' + max + ' kí tự!';
            }
        }
    }
    //Lấy ra form element trong DOM theo 'formCV'
    var formElement = document.querySelector(formCV);
    // console.log(formElement);

//   Chỉ xử lý khi trong form element trong DOM
     if(formElement) {

         var inputs = formElement.querySelectorAll('[name][rules]');
         for (var input of inputs){
             var rules = input.getAttribute('rules').split('|');
             formRules[input.name] = input.getAttribute('rules')
             for (var rule of rules){
                 var ruleInfo;
                 var isRuleHasValue = rule.includes(':');

                 if(isRuleHasValue) {
                     ruleInfo = rule.split(':');
                     rule = ruleInfo[0];
                 }

                 var ruleFunc = validatorRules[rule];

                 if(isRuleHasValue) {
                     ruleFunc = ruleFunc(ruleInfo[1]);
                 }

                 if (Array.isArray(formRules[input.name])){
                     formRules[input.name].push(ruleFunc);
                 }else {
                     formRules[input.name] = [ruleFunc];
                 }
             }

         //   Lắng nghe sự kiện validate(blur, change,...)
             input.onblur = handleValidate;
             input.oninput = handleClearError;
         }
         function handleValidate(event){
             var rules = formRules[event.target.name];
             var errorMessage;
             rules.find(function (rule){
                 errorMessage = rule(event.target.value);
                 return errorMessage;
             });

         //    Nếu có lỗi thì hiện thị message lỗi ra UI
             if(errorMessage) {
                 var formGroup = getParent(event.target, '.form-group');
                 if(formGroup) {
                     var formInput = formGroup.querySelector('.form-control');
                     var formMessage = formGroup.querySelector('.form-message');
                     // console.log(formInput);
                     if(formMessage) {
                         formInput.classList.add('is-invalid');
                         formMessage.classList.add('text-warning');
                         formMessage.innerText = errorMessage;
                     }
                 }
             }
             return !errorMessage;
         }

         //Hàm clear message lỗi
         function handleClearError(event) {
             var formGroup = getParent(event.target, '.form-group');
             if(formGroup) {
                 var formInput = formGroup.querySelector('.form-control');
                 var formMessage = formGroup.querySelector('.form-message');
                 if(formInput.classList.contains('is-invalid') && formMessage.classList.contains('text-warning')){
                    formInput.classList.remove('is-invalid');
                    formMessage.classList.remove('text-warning');
                    if(formMessage){
                        formMessage.innerText = '';
                    }
                 }
             }
             }
         //Xử lý hành vi submit form
         formElement.onsubmit = function (event) {
            event.preventDefault();
             var inputs = formElement.querySelectorAll('[name][rules]');
             var isValid = true;
             for (var input of inputs){
                 if(!handleValidate({target: input})) {
                     isValid = false;
                 }
             }
             if(isValid){
                 formElement.submit();
             }
             console.log(isValid);
         }
         // console.log(formRules);
     }
}