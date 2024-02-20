async function all_items(){ 
    const url = "http://localhost:8080/store";
    new_display(url, "shop-display");
}

async function category(){
    const search_bar = document.getElementById("cat-bar");
    const nation = search_bar.options[search_bar.selectedIndex].value;
    if (nation=="All"){
        all_items();
    }
    const url = "http://localhost:8080/store/nations/"+nation;
    console.log(url);
    new_display(url, "shop-display");
}

async function new_display(url, element){
    try{
        console.log("fetching");
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

    /*
    const item_desc = document.createElement("p");
    item_desc.innerHTML = product.description;
    item.appendChild(item_desc);
    */
            
    place.appendChild(item);
}