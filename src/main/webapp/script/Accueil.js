/**
 * 
 */

$('#radioAchats').change(function(){
    $('#enchereOuverte').prop("disabled", !this.checked);
}).change()


// assign onclick handler to hazard checkbox
document.getElementById('radioAchats').onclick = function() {

    // is hazard checkbox checked?
    var radio = this.checked; // true or false

    var checkbox = this.form.elements['checkboxAchats'];

    // loop through list of radio buttons
    for (var i=0, len=checkbox.length; i<len; i++) {
        var c = checkbox[i]; // current radio button

        if ( !radio ) { // hazard checkbox checked
            c.disabled = true;
        } else { // hazard not checked
            c.disabled = false; // no radios disabled
        }

    }
}

document.getElementById('radioVentes').onclick = function() {

    // is hazard checkbox checked?
    var radio = this.checked; // true or false

    var checkbox = this.form.elements['checkboxVentes'];

    // loop through list of radio buttons
    for (var i=0, len=checkbox.length; i<len; i++) {
        var c = checkbox[i]; // current radio button

        if ( !radio ) { // hazard checkbox checked
            c.disabled = true;
        } else { // hazard not checked
            c.disabled = false; // no radios disabled
        }

    }
}