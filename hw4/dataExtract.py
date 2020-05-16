import json
found = {}
def nestedSearch(elements, input):
    if type(elements) != type([]):
        elements = [elements]

    if type(input) == type(dict()):
        for needle in elements:
            if needle in input.keys():
                found[needle] = input[needle]
            elif len(input.keys()) > 0:
                for key in input.keys():
                    result = nestedSearch(needle, input[key])
                    if result:
                        for k, v in result.items():
                            found[k] = v
    elif type(input) == type([]):
        for node in input:
            result = nestedSearch(elements, node)
            if result:
                for k, v in result.items():
                    found[k] = v
    return found
f = open('/Users/tianhangzhang/Documents/hw/hw1/Java9/hw4/data.json')
data = json.load(f)

nestedSearch("orderType", data)
nestedSearch("dueToday", data)
nestedSearch("email", data)
nestedSearch("shippingAddress", data)
print(found)


with open('output', 'w') as outfile:
    json.dump(found, outfile)