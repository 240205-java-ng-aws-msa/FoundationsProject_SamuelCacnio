async function all_items(){ 
    const url = "http://localhost:8080/store";
    big_display(url, "shop-display");
}

async function category(){
    const search_bar = document.getElementById("cat-bar");
    const nation = search_bar.options[search_bar.selectedIndex].value;
    if (nation=="All"){
        all_items();
    }
    else{
        const url = "http://localhost:8080/store/nations/"+nation;
        big_display(url, "shop-display");
    }
}

async function big_display(url, element){
    try{
        const res = await fetch(url);
        if (res.status === 200){
            const data = await res.json();
            const place = document.getElementById(element);
            while (place.firstChild){
                place.lastChild.remove();
            }
            for (product of data){
                single_display(product, place);
            }
        }
        else{
            console.log("fail");
        }
    }  
    catch (err){
        console.log(err);
    }
}

function single_display(product, place){
    const item = document.createElement("div");
    item.setAttribute("class", "item");

    const item_name = document.createElement("p");
    item_name.innerHTML = product.name;
    item.appendChild(item_name);

    const item_img_url = product.image_path;
    const item_img = document.createElement("img");
    item_img.setAttribute("src", item_img_url);
    item_img.setAttribute("alt", "Failed to load "+item_name);
    item.appendChild(item_img);
            
    const item_price = document.createElement("p");
    item_price.innerHTML = "$"+product.price;
    item.appendChild(item_price);

    const desc = document.createElement("p");
    desc.innerHTML = product.description;
    item.appendChild(desc);

    const q_label = document.createElement("label")
    q_label.setAttribute("for", `Quant_${product.name}`);
    q_label.innerHTML = "Quantity Desired:";
    item.append(q_label);

    const quantity = document.createElement("input");
    quantity.setAttribute("type", "number");
    quantity.setAttribute("id", `Quant_${product.name}`);
    quantity.setAttribute("value", "1");
    item.appendChild(quantity);

    const cart_button = document.createElement("input");
    cart_button.setAttribute("type","button");
    cart_button.setAttribute("value","Add to Cart");
    //implement add_to_cart function
    item.appendChild(cart_button);
            
    place.appendChild(item);
}

function add_to_cart(){
    console.log("test");
}