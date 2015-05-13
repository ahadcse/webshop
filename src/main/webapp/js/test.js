var test = function test(name)
{
	document.write('This is ' + name);	
	window.alert('Hi! ' + name);
}

function availableOption()
{
	new Option(0, "Option 0");	
	new Option(1, "Option 1");	
	new Option(2, "Option 2");	
}

function Option(id, name) {
    this.id = id;
    this.name = name;
}