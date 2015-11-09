(function() {
  var $;

  $ = jQuery;

  $(document).ready(function() {
    $('.main.menu').visibility({
      type: 'fixed'
    });
    $('.overlay').visibility({
      type: 'fixed',
      offset: 80
    });
    return $('.main.menu  .ui.dropdown').dropdown({
      on: 'hover'
    });
  });

  $(".ak-dropdown").dropdown();

}).call(this);
