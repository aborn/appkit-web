$ = jQuery

$(document).ready(() ->

  $('.main.menu').visibility({
    type: 'fixed'
  })
  $('.overlay').visibility({
    type: 'fixed',
    offset: 80
  })

  $('.main.menu  .ui.dropdown').dropdown({
    on: 'hover'
  })
)

$(".ak-dropdown").dropdown();