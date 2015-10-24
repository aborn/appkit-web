module.exports = (grunt) ->
  require('load-grunt-tasks')(grunt);

  version = ->
    grunt.file.readJSON("package.json").version
  version_tag = ->
    "v#{version()}"

  grunt.initConfig
    pkg: grunt.file.readJSON("package.json")
    minified_comments: "/* appkit #{version_tag()} | (c) 2015-<%= grunt.template.today('yyyy') %> by Aborn Jiang\n"

    coffee:
      options:
        join: true
      compile:
        files:
          'src/main/webapp/assets/js/appkit.js': ['src/main/webapp/coffee/common.coffee']

    uglify:
      options:
        mangle:
          except: ['jQuery']
        banner: "<%= minified_comments %>"
      minified_chosen_js:
        files:
          'src/main/webapp/assets/js/appkit.min.js': ['src/main/webapp/assets/js/appkit.js']

    compass:
      chosen_css:
        options:
          bundleExec: true
          specify: ['src/main/webapp/sass/base.scss']

    cssmin:
      minified_chosen_css:
        options:
          banner: "<%= minified_comments %>"
          keepSpecialComments: 0
        src: 'src/main/webapp/assets/css/base.css'
        dest: 'src/main/webapp/assets/css/base.min.css'

    watch:
      scripts:
        files: ['src/main/webapp/coffee/**/*.coffee', 'src/main/webapp/sass/*.scss']
        tasks: ['build']

    copy:
      main:
        files:
          [{
            expand: true,
            cwd: 'node_modules/semantic-ui/dist/'
            src: ['**'],
            dest: 'src/main/webapp/ui/semantic-ui/dist/',
            filter: 'isFile'}
          ]

  grunt.registerTask 'preBuild', 'some prepare task before build', () ->
    grunt.file.delete("src/main/webapp/assets/css/base.css")

  grunt.registerTask 'postBuild', 'some post task after build', () ->
    content = grunt.file.read("README.md");
    len = content.length
    content = content.substring(0, len - 11)
    date = grunt.template.date(new Date(), 'yyyy-mm-dd');
    grunt.file.write("README.md", content + "\n" + date)

  grunt.registerTask 'ui', 'install semantic ui to web', () ->
    grunt.file.copy('node_modules/semantic-ui/dist', 'src/main/webapp/ui/semantic-ui/')

  grunt.registerTask 'default', ['preBuild', 'build', 'postBuild']
  grunt.registerTask 'build', ['copy','coffee', 'compass', 'uglify', 'cssmin']
  grunt.registerTask 'test',  ['coffee']
