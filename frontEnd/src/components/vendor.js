const Vendor= (props)=> {

    const { vendor }= props

    return (
        <div className="object">
        <div>{vendor.name}</div>
        <div>{vendor.garage}</div>
        <div>{vendor.exact_Address}</div>
        <div>{vendor.email}</div>
        <div>{vendor.password}</div>
        <div>{vendor.address}</div>
        <div>{vendor.contact}</div>
        <div>{vendor.answer}</div>
      </div>
    )
}

export default Vendor