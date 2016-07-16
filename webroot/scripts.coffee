# setup our application with its own namespace 
App = {}


###
	Init
###
App.init = ->
  App.canvas = document.createElement 'canvas' #create the canvas element
  App.canvas.height = 400
  App.canvas.width = 800  #size it up
  document.getElementsByTagName('article')[0].appendChild(App.canvas) #append it into the DOM

  App.ctx = App.canvas.getContext("2d") # Store the context

  # set some preferences for our line drawing.
  App.ctx.fillStyle = "solid"
  App.ctx.strokeStyle = "#ECD018"
  App.ctx.lineWidth = 5
  App.ctx.lineCap = "round"

  App.ctx.fillRect(10,10,200,200)

  # Sockets!
  App.socket = io.connect('http://localhost:9191')

  App.socket.on 'draw', (data) ->
    console.log(data)
#    App.draw(data.x,data.y,data.type)

  # Draw Function
  App.draw = (type,x,y,w,h) ->
    if type is "rect"
      App.ctx.fillRect(x,y,w,h)
    else
      console.log(type + "not implemented")
  return




###
	Draw Events
###
#$('canvas').live 'drag dragstart dragend', (e) ->
#  type = e.handleObj.type
#  offset = $(this).offset()
#
#  e.offsetX = e.layerX - offset.left
#  e.offsetY = e.layerY - offset.top
#  x = e.offsetX
#  y = e.offsetY
#  App.draw(x,y,type)
#  App.socket.emit('drawClick', { x : x, y : y, type : type})
#  return



# jQuery document.ready
$ ->
  App.init()