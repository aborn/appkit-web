$('.menu .item').tab();

$('.cityTab').on('click', function(){
    $('.model-scrolling-container').visibility({
        once: false,
        // update size when new content loads
        observeChanges: true,
        // load content on bottom edge visible
        onBottomVisible: function() {
            // loads a max of 5 times
            //window.loadFakeContent();
            console.log('99999')
        }
    });
});